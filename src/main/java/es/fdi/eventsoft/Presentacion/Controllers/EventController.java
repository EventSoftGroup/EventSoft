package es.fdi.eventsoft.Presentacion.Controllers;

import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
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

        System.out.println("******************************************");
        System.out.println(email);
        System.out.println(evento);
        System.out.println("******************************************");

        if (bindingResult.hasErrors()) {
            model.addAttribute("tipoUsuario", "organizador");
            model.addAttribute("CategoriasEvento", Arrays.asList(Evento.CategoriasEvento.values()));

            for(ObjectError err: bindingResult.getAllErrors())
                System.out.println(err);
            return "nuevo-evento";
        }





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
