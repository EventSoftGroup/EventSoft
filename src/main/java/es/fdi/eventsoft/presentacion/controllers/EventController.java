package es.fdi.eventsoft.presentacion.controllers;

import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Organizador;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;

@Controller
@RequestMapping("/eventos/")
public class EventController {

    private Logger log = LoggerFactory.getLogger(ServiciosController.class);

    @RequestMapping("/nuevo")
    public String nuevoEvento(Model model) {
        model.addAttribute("title", "EventSoft - Nuevo evento");
        model.addAttribute("pagina", "nuevo-evento");
        model.addAttribute("evento", new Evento());
        model.addAttribute("CategoriasEvento", Arrays.asList(Evento.CategoriasEvento.values()));


        return "nuevo-evento";
    }

    @RequestMapping("/calendario")
    public String eventoCalendario(Model model) {
        model.addAttribute("title", "EventSoft - Calendario");
        model.addAttribute("pagina", "calendario");
        return "calendario";
    }

    @RequestMapping("/proveedores")
    public String eventoProveedores(Model model) {
        model.addAttribute("title", "EventSoft - Proveedores");
        model.addAttribute("pagina", "proveedores");
        return "proveedores";
    }

    @RequestMapping("/leer-mensaje")
    public String eventoLeerMensaje(Model model) {
        model.addAttribute("title", "EventSoft - Leer Mensaje");

        return "leer-mensaje";
    }

    @RequestMapping("/timeline")
    public String eventoTimeline(Model model) {
        model.addAttribute("title", "EventSoft - Timeline");
        model.addAttribute("pagina", "timeline");
        model.addAttribute("listaTiposServicio", Servicio.TiposServicio.values());

        return "timeline";
    }

    @RequestMapping("/notificaciones")
    public String eventoNotificaciones(Model model) {
        model.addAttribute("title", "EventSoft - Notificaciones");

        return "notificaciones";
    }

    @RequestMapping("/leer-notificacion")
    public String eventoLeerNotificacion(Model model) {
        model.addAttribute("title", "EventSoft - Leer-Notificación");

        return "leer-notificacion";
    }

    @RequestMapping(value = "crearEvento", method = RequestMethod.POST)
    public String crearEvento(@Valid Evento evento, BindingResult bindingResult, Model model, HttpSession session,
        @RequestParam(value = "email") String email){

        long time_start, time_end;
        time_start = System.currentTimeMillis();

        if (bindingResult.hasErrors() || email.trim().isEmpty()) {
            model.addAttribute("tipoUsuario", "organizador");
            model.addAttribute("CategoriasEvento", Arrays.asList(Evento.CategoriasEvento.values()));
            return "nuevo-evento";
        }


        evento.setCliente(new Cliente(email));
        evento.setOrganizador((Organizador) session.getAttribute("usuario"));

        Contexto contex = FactoriaComandos.getInstance().crearComando(CREAR_EVENTO).execute(evento);

        if(contex.getEvento() == CREAR_EVENTO){
            model.addAttribute("tipoUsuario", "organizador");
            model.addAttribute("CategoriasEvento", Arrays.asList(Evento.CategoriasEvento.values()));
            time_end = System.currentTimeMillis();
            System.out.println("The task has taken "+ ( time_end - time_start ) +" milliseconds");
            return "timeline";
        }else if (contex.getEvento() == ERROR_CREAR_EVENTO){
            model.addAttribute("tipoUsuario", "organizador");
            model.addAttribute("CategoriasEvento", Arrays.asList(Evento.CategoriasEvento.values()));
            return "nuevo-evento";
        }

        time_end = System.currentTimeMillis();
        System.out.println("The task has taken "+ ( time_end - time_start ) +" milliseconds");

        return "nuevo-evento";
    }

    @RequestMapping(value = "añadirServiciosAEvento/{idEvento}",  method = RequestMethod.POST, produces = "application/json")
    public String añadirServiciosAEvento(@PathVariable Long idEvento, @RequestParam(value="servicios[]") String[] servicios) {

        List<Long> listaIDs = new ArrayList<>();

        Arrays.stream(servicios)
                .mapToLong((str)-> Long.parseLong(str))
                .forEach((str)-> listaIDs.add(Long.parseLong(String.valueOf(str))));


        System.out.println("*********************************************");
        System.out.println("idEvento: " + idEvento);
        System.out.println("listaServicios: " +listaIDs);

        System.out.println("*********************************************");


        if(idEvento>0){
            Contexto contex = FactoriaComandos.getInstance().crearComando(AÑADIR_SERVICIOS_A_EVENTO).execute(new Pair<>(idEvento,  listaIDs));

            System.out.println(contex.getEvento());

            return "redirect:../timeline";
        }


        return "redirect:../timeline";
    }




    @RequestMapping(value = "buscarEvento/{idEvento}",  method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<Evento> buscarEvento(Model model, @PathVariable Long idEvento) {
        Contexto contex;
        Usuario usuario = new Usuario();

        contex = FactoriaComandos.getInstance().crearComando(BUSCAR_EVENTO).execute(idEvento);

        return new ResponseEntity<>((Evento)contex.getDatos(), HttpStatus.OK);
    }

    @RequestMapping("modificarEvento")
    public String modificarEvento(Model model) {
        //TODO


        return null;
    }

    @RequestMapping("eliminarEvento")
    public String eliminarEvento(Model model) {
        //TODO


        return null;
    }

    @RequestMapping(value = "buscarEventosByUser",  method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<List<Evento>> buscarEventosByUser(Model model, HttpSession session) {

        Contexto contex;
        Usuario usuario = new Usuario();

        usuario.setId(((Usuario) session.getAttribute("usuario")).getId());
        usuario.setEmail(((Usuario) session.getAttribute("usuario")).getEmail());

        contex = FactoriaComandos.getInstance().crearComando(BUSCAR_EVENTOS_BY_USUARIO).execute(usuario);

        return new ResponseEntity<>((List<Evento>) contex.getDatos(), HttpStatus.OK);

    }

}
