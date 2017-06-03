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

    public static boolean isLogin(Model model, HttpSession session){

        Usuario user = (Usuario) session.getAttribute("usuario");
        if(user == null){
            model.addAttribute("title", "EventSoft");
            model.addAttribute("userLog", new Usuario());
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String home( @ModelAttribute("userLog") Usuario userLog, BindingResult bindingResult, Model model, HttpSession session) {

        if(userLog.getEmail().trim().isEmpty()){
            bindingResult.rejectValue("email" , "error.userLog", "Introduzca un Email valido");
            return "login";
        }else if(userLog.getPassword().trim().isEmpty()){
            bindingResult.rejectValue("password" , "error.userLog", "Instroduzca una contraseña");
            return "login";
        }

        Contexto contex = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_USUARIO_BY_EMAIL).execute(userLog.getEmail());

        model.addAttribute("title", "EventSoft");

        if(contex.getEvento() == EventosNegocio.BUSCAR_USUARIO_BY_EMAIL) {
            Usuario user = (Usuario) contex.getDatos();

            if (user.getPassword().equals(userLog.getPassword())) {

                session.setAttribute("usuario", user);
                if(user instanceof Cliente) {
                session.setAttribute("rol", "Cliente");
                model.addAttribute("pagina", "perfil-usuario");
                return "redirect:./usuarios/perfil-usuario";
                }

                if(user instanceof Organizador) {
                    session.setAttribute("rol", "Organizador");
                    model.addAttribute("pagina", "timeline");
                    return "redirect:./eventos/timeline";
                }

                if(user instanceof Proveedor) {
                    System.out.println("Logueado como Proveedor");
                    session.setAttribute("rol", "Proveedor");
                    model.addAttribute("pagina", "proveedores");
                    return "redirect:./eventos/proveedores";
                }

                if(user.getEmail().equals("adminIW@ucm.es")) {
                    session.setAttribute("rol", "Administrador");
                    model.addAttribute("pagina", "admin");
                    return "admin";
                }
            }else{
                bindingResult.rejectValue("password" , "error.userLog", "Contraseña incorrecta");
            }
        }else{
            bindingResult.rejectValue("email" , "error.userLog", "Email incorrecto");
        }

        return "login";
    }

    @RequestMapping({"/","login"})
    public String login(Model model) {
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
        return "redirect:login";
    }

    @RequestMapping("500")
    public String getErrorr500(HttpSession session, SessionStatus status, Model model) {
        return "error-500";
    }

}

