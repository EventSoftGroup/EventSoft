package es.fdi.eventsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/administracion/")
public class AdminController {
    @RequestMapping("admin")
    public String home(Model model) {
        model.addAttribute("title", "EventSoft");

        return "admin";
    }
}