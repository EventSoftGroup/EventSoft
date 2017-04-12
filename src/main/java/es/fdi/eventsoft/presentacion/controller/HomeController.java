package es.fdi.eventsoft.presentacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

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

    @RequestMapping("pagina-guardar")
    public String singleFieldPage() {

        return "pagina-guardar";
    }

    @RequestMapping("guarda-nombre")
    public String rememberThought(HttpSession session, @RequestParam String nombre) {
        session.setAttribute("miNombre", nombre);
        return "pagina-guardar";
    }

    @RequestMapping("muestra-sesion")
    public String pruebaFinita() {
        return "muestra-sesion";
    }

    @RequestMapping("eliminar-sesion")
    public String eliminaNombre(HttpSession session, SessionStatus status, Model model) {
        System.out.println("Eliminando atributo: " + session.getAttribute("miNombre"));
        session.removeAttribute("miNombre");
        status.setComplete();
        System.out.println("Atributo eliminado");
        System.out.println(session.getAttribute("miNombre"));
        return "pagina-guardar";
    }
}
