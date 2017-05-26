package es.fdi.eventsoft.Presentacion.Controllers;


import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private Logger log = LoggerFactory.getLogger(ServiciosController.class);

    public static boolean isLogin(Model model, HttpSession session){

        Usuario user = (Usuario) session.getAttribute("usuario");
        if(user == null){
            model.addAttribute("title", "EventSoft");
            model.addAttribute("userLog", new Usuario());
            return false;
        }

        return true;
    }

    @RequestMapping("index")
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

    @RequestMapping("sign-out")
    public String signOut(HttpSession session, SessionStatus status, Model model) {
        session.removeAttribute("rol");
        session.removeAttribute("usuario");
        status.setComplete();
        return "redirect:login";
    }



    @RequestMapping("500")
    public String getErrorr500(HttpSession session, SessionStatus status, Model model) {
        return "error-500";
    }

}

