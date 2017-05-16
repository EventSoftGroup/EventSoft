package es.fdi.eventsoft.Presentacion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventos/")
public class EventController {
    @RequestMapping("/nuevo")
    public String nuevoEvento(Model model) {
        model.addAttribute("title", "EventSoft - Nuevo evento");
        model.addAttribute("pagina", "nuevo-evento");
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



    @RequestMapping("crearEvento")
    public String crearEvento(Model model) {
        //TODO

        return null;
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
