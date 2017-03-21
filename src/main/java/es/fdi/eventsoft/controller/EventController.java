package es.fdi.eventsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventos/")
public class EventController {
    @RequestMapping("/nuevo")
    public String nuevoEvento(Model model) {
        model.addAttribute("title", "EventSoft - Nuevo evento");

        return "nuevo-evento";
    }
    @RequestMapping("/calendario")
    public String eventoCalendario(Model model) {
        model.addAttribute("title", "EventSoft - Calendario");

        return "calendario";
    }
    @RequestMapping("/proveedores")
    public String eventoProveedores(Model model) {
        model.addAttribute("title", "EventSoft - Proveedores");

        return "proveedores";
    }
    @RequestMapping("/buzon")
    public String eventoBuzon(Model model) {
        model.addAttribute("title", "EventSoft - Buzón");

        return "buzon";
    }
    @RequestMapping("/leer-mensaje")
    public String eventoLeerMensaje(Model model) {
        model.addAttribute("title", "EventSoft - Leer Mensaje");

        return "leer-mensaje";
    }
    @RequestMapping("/nuevo-mensaje")
    public String eventoNuevoMensaje(Model model) {
        model.addAttribute("title", "EventSoft - Nuevo Mensaje");

        return "nuevo-mensaje";
    }
    @RequestMapping("/timeline")
    public String eventoTimeline(Model model) {
        model.addAttribute("title", "EventSoft - Timeline");

        return "timeline";
    }


}
