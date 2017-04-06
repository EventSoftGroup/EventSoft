package es.fdi.eventsoft.presentacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios/")
public class UserController {
    @RequestMapping("perfil-usuario")
    public String home(Model model) {
        model.addAttribute("title", "EventSoft");

        return "perfil-usuario";
    }
}