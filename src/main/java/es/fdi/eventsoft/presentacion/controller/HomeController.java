package es.fdi.eventsoft.presentacion.controller;

import es.fdi.eventsoft.negocio.modelo.Cliente;
import es.fdi.eventsoft.negocio.modelo.Organizador;
import es.fdi.eventsoft.negocio.modelo.Proveedor;
import es.fdi.eventsoft.negocio.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    //Ejemplos de sesiones (Esto se borrará cuando todos los integrantes del grupo le echen un vistazo)

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

    //End sesiones_________________________________________________________________________

    /*
        Registro de un usuario.
     */

    @RequestMapping(value = "registrar_usuario", method = RequestMethod.POST)
    public String registrar_usuario(@ModelAttribute("Cliente") Cliente cliente,
                                    @ModelAttribute("Organizador") Organizador organizador,
                                    @ModelAttribute("Proveedor") Proveedor proveedor,
                                    @RequestParam String seleccion,
                                    HttpSession session) {

        //Creo una nueva variable usuario que utilizaré para guardarlo en sesión.
        Usuario usuario = null;

        if (seleccion.equalsIgnoreCase("cliente")) {
            System.out.println("Tengo un nuevo cliente con nombre: " + cliente.getNombre());
            session.setAttribute("nombre", cliente.getNombre());
            session.setAttribute("rol", "cliente");
        } else if (seleccion.equalsIgnoreCase("organizador")) {
            System.out.println("Tengo un nuevo organizador con nombre: " + organizador.getEmpresa());
            session.setAttribute("nombre", organizador.getEmpresa());
            session.setAttribute("rol", "organizador");
        } else if (seleccion.equalsIgnoreCase("proveedor")) {
            System.out.println("Tengo un nuevo proveedor con nombre: " + proveedor.getEmpresa());
            session.setAttribute("nombre", organizador.getEmpresa());
            session.setAttribute("rol", "proveedor");
        }

        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        session.setAttribute("fecha_registro", formateador.format(ahora));

        return "index";
    }
}

