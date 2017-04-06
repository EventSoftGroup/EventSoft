package es.fdi.eventsoft.presentacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administracion/")
public class AdminController {
    @RequestMapping("admin")
    public String home(Model model) {
        model.addAttribute("title", "EventSoft");

        return "admin";
    }
}