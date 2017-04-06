package es.fdi.eventsoft.presentacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("index")
    public String home(Model model) {
        model.addAttribute("title", "EventSoft");

        return "index";
    }

    @RequestMapping({"/","login"})
    public String login(Model model) {
        model.addAttribute("title", "EventSoft");

        return "login";
    }

    @RequestMapping("register")
    public String register(Model model) {
        model.addAttribute("title", "EventSoft");

        return "register";
    }


}
