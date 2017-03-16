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
}
