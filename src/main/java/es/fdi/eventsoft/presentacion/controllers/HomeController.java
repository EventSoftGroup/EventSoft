package es.fdi.eventsoft.presentacion.controllers;


import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Organizador;
import es.fdi.eventsoft.negocio.entidades.usuario.Proveedor;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    private Logger log = LoggerFactory.getLogger(ServiciosController.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public static boolean isLogin(Model model, HttpSession session){

        Usuario user = (Usuario) session.getAttribute("usuario");
        if(user == null){
            model.addAttribute("title", "EventSoft");
            model.addAttribute("userLog", new Usuario());
            return false;
        }

        return true;
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcome(Model model, HttpSession session) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Contexto contex = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_USUARIO_BY_EMAIL).execute(user.getUsername());

        model.addAttribute("title", "EventSoft");

        if(contex.getEvento() == EventosNegocio.BUSCAR_USUARIO_BY_EMAIL) {
            Usuario usuario = (Usuario) contex.getDatos();

            session.setAttribute("usuario", usuario);

            if(usuario.getRoles().equalsIgnoreCase("ADMIN")) {
                session.setAttribute("rol", "Administrador");
                model.addAttribute("pagina", "admin");
                return "redirect:./administracion/admin";

            } else if (usuario instanceof Cliente) {
                session.setAttribute("rol", "Cliente");
                model.addAttribute("pagina", "perfil-usuario");
                return "redirect:./usuarios/perfil-usuario";

            } else if (usuario instanceof Organizador) {
                session.setAttribute("rol", "Organizador");
                model.addAttribute("pagina", "timeline");
                return "timeline";

            } else if (usuario instanceof Proveedor) {
                session.setAttribute("rol", "Proveedor");
                model.addAttribute("pagina", "proveedores");
                return "redirect:./servicios/buscar/por-proveedor/" + usuario.getId();
            }
        }

        return "redirect:/500";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Usuario o Contraseña incorrectos.");
        }

        if (logout != null) {
            model.addAttribute("message", "Sesión cerrada correctamente.");
        }

        model.addAttribute("title", "EventSoft");
        model.addAttribute("userLog", new Usuario());

        return "login";
    }

    @RequestMapping("/logout")
    public String signOut(HttpSession session, SessionStatus status, Model model) {
        session.removeAttribute("rol");
        session.removeAttribute("usuario");
        session.invalidate();
        status.setComplete();

        return "redirect:login?logout";
    }

    @RequestMapping("/500")
    public String getErrorr500(HttpSession session, SessionStatus status, Model model) {
        return "error-500";
    }

}

