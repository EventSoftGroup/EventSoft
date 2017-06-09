package es.fdi.eventsoft.presentacion.controllers;

import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Organizador;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.entidades.validadores.EventValidator;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;

@Controller
@RequestMapping("/eventos")
public class EventController {

    private Logger log = LoggerFactory.getLogger(ServiciosController.class);

    private EventValidator eventValidator = new EventValidator();

    @PersistenceContext
    private EntityManager entityManager;

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

    @RequestMapping(value = "/crear-evento", method = RequestMethod.POST)
    public String crearEvento(@Valid Evento evento, BindingResult bindingResult, Model model, HttpSession session,
        @RequestParam(value = "email") String email){

        if(bindingResult.hasErrors() || (email.trim().isEmpty())){

            System.out.println(email.trim());
            System.out.println("ALGUN ERROR");
            model.addAttribute("tipoUsuario", "organizador");
            model.addAttribute("CategoriasEvento", Arrays.asList(Evento.CategoriasEvento.values()));
            return "nuevo-evento";
        }


        evento.setCliente(new Cliente(email));
        evento.setOrganizador((Organizador) session.getAttribute("usuario"));

        System.out.println(evento);
        Contexto contex = FactoriaComandos.getInstance().crearComando(CREAR_EVENTO).execute(evento);

        if(contex.getEvento() == CREAR_EVENTO){
            model.addAttribute("tipoUsuario", "organizador");
            model.addAttribute("CategoriasEvento", Arrays.asList(Evento.CategoriasEvento.values()));
            return "timeline";
        }else if (contex.getEvento() == ERROR_CREAR_EVENTO){
            System.out.println(ERROR_CREAR_EVENTO);
            model.addAttribute("tipoUsuario", "organizador");
            model.addAttribute("CategoriasEvento", Arrays.asList(Evento.CategoriasEvento.values()));
            return "nuevo-evento";
        }

        System.out.println("FINAL ABSOLUTO");
        return "nuevo-evento";
    }

    private Date formateaFecha(String fechaInicio) {

        DateFormat dateFormat;
        Date fecha = null;

        try {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            fecha = dateFormat.parse(fechaInicio);
        } catch (ParseException e) {

            try {
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                fecha = dateFormat.parse(fechaInicio);
            } catch (ParseException e1) {
                fecha = null;
            }
        }

        return fecha;
    }

    @RequestMapping(value = "/anadir-servicios-evento/{idEvento}",  method = RequestMethod.POST, produces = "application/json")
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

    @RequestMapping(value = "/buscar/{idEvento}",  method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<Evento> buscarEvento(Model model, @PathVariable Long idEvento) {
        Contexto contex;
        Usuario usuario = new Usuario();

        contex = FactoriaComandos.getInstance().crearComando(BUSCAR_EVENTO).execute(idEvento);

        return new ResponseEntity<>((Evento)contex.getDatos(), HttpStatus.OK);
    }

    @RequestMapping(value = "/vista-modificar/{idEvento}", method = RequestMethod.GET)
    public String vistaModificarEvento(@PathVariable Long idEvento, Model model) {
        Contexto contex = FactoriaComandos.getInstance().crearComando(BUSCAR_EVENTO).execute(idEvento);
        model.addAttribute("eventoAModificar", (Evento) contex.getDatos());
        model.addAttribute("CategoriasEvento", Evento.CategoriasEvento.values());

        return "modificar-evento";
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.POST)
    public String modificarEvento(@ModelAttribute("eventoAModificar") Evento eventoNuevo, BindingResult bindingResult, Model model) {

        eventValidator.validate(eventoNuevo, bindingResult);

        if(bindingResult.hasErrors()){
            model.addAttribute("eventoAModificar", eventoNuevo);
            model.addAttribute("CategoriasEvento", Evento.CategoriasEvento.values());

           return "modificar-evento";
        }
        else{
            Evento original = FactoriaSA.getInstance().crearSAEventos().buscarEventoParaModificar(eventoNuevo.getId());
            original.setNombre(eventoNuevo.getNombre());
            original.setCategoria(eventoNuevo.getCategoria());
            original.setLugar(eventoNuevo.getLugar());
            original.setDescripcion(eventoNuevo.getDescripcion());
            original.setFechaInicio(eventoNuevo.getFechaInicio());
            original.setFechaFin(eventoNuevo.getFechaFin());
            Contexto c = FactoriaComandos.getInstance().crearComando(MODIFICAR_EVENTO).execute(original);

            if(c.getEvento() == MODIFICAR_EVENTO){
                model.addAttribute("listaTiposServicio", Servicio.TiposServicio.values());
                return "timeline";
            }
            else{
                return "error-401";
            }
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminarEvento(@PathVariable("id") Long id, Model model) {
        if (id > 0) {
            Contexto contexto = FactoriaComandos.getInstance().crearComando(ELIMINAR_EVENTO).execute(id);

            if (contexto.getEvento() == ELIMINAR_EVENTO) {
                return "redirect:../timeline";
            } else {
                return "error-500";
            }
        }
        else return "redirect:../timeline";

    }

    @RequestMapping(value = "/buscar/por-usuario",  method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<List<Evento>> buscarEventosByUser(Model model, HttpSession session) {

        Contexto contex;
        Usuario usuario = new Usuario();

        usuario.setId(((Usuario) session.getAttribute("usuario")).getId());
        usuario.setEmail(((Usuario) session.getAttribute("usuario")).getEmail());

        contex = FactoriaComandos.getInstance().crearComando(BUSCAR_EVENTOS_BY_USUARIO).execute(usuario);

        return new ResponseEntity<>((List<Evento>) contex.getDatos(), HttpStatus.OK);

    }

}
