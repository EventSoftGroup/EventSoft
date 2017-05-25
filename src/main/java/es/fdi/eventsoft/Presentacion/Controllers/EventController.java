package es.fdi.eventsoft.Presentacion.Controllers;

import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.CREAR_EVENTO;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_CREAR_EVENTO;

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

    @RequestMapping("buscarEvento")
    public String buscarEvento(Model model) {
        //TODO


        return null;
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

    @RequestMapping("buscarEventosByUser")
    public String buscarEventosByUser(Model model) {
        //TODO


        return null;
    }

}
