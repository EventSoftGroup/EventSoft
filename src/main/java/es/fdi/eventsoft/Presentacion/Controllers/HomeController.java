package es.fdi.eventsoft.Presentacion.Controllers;


import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping({"/","index"})
    public String home(HttpSession session,
                       @RequestParam (value = "seleccion", required = false, defaultValue = "error") String seleccion,
                       @RequestParam (value = "pass", required = false, defaultValue = "vacia") String pass,
                       Model model) {

        model.addAttribute("title", "EventSoft");

        //En el caso de que selección venga vacio colocamos le asignamos el valor del rol guarado en sesión.
        if (seleccion.equalsIgnoreCase("error")){
            seleccion = (String) session.getAttribute("rol");
            //Si no tenemos nada en la variable sesión, le damos vacio para que vaya a login.
            if (seleccion == null) {
                seleccion = "";
            }
        }

        switch (seleccion) {
            case "Cliente": {
                session.setAttribute("rol", "Cliente");
                model.addAttribute("pagina", "perfil-usuario");
                return "redirect:./usuarios/perfil-usuario";
            }

            case "Organizador": {
                session.setAttribute("rol", "Organizador");
                model.addAttribute("pagina", "nuevo-evento");
                return "redirect:./eventos/nuevo";
            }

            case "Proveedor": {
                System.out.println("Logueado como Proveedor");
                session.setAttribute("rol", "Proveedor");
                model.addAttribute("pagina", "proveedores");
                return "redirect:./eventos/proveedores";
            }

            case "Admin": {
                session.setAttribute("rol", "Administrador");
                model.addAttribute("pagina", "admin");
                return "admin";
            }
            default: {
                return "login";
            }
        }
    }

    @RequestMapping("login")
    public String login(Model model) {
        model.addAttribute("title", "EventSoft");
        return "login";
    }



    @RequestMapping("sign-out")
    public String signOut(HttpSession session, SessionStatus status, Model model) {
        session.removeAttribute("rol");
        status.setComplete();
        return "redirect:login";
    }


    @RequestMapping("500")
    public String getErrorr500(HttpSession session, SessionStatus status, Model model) {
        return "error-500";
    }

}

