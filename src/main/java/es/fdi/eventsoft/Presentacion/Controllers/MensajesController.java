package es.fdi.eventsoft.Presentacion.Controllers;

import com.sun.org.apache.regexp.internal.RE;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import org.hibernate.service.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.CREAR_MENSAJE;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_CREAR_MENSAJE;
import static es.fdi.eventsoft.Presentacion.Controllers.HomeController.isLogin;

import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;


/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
@Controller
@RequestMapping("/mensajes/")
public class MensajesController {




    @GetMapping("/buzon")
    public String eventoBuzon(Model model, HttpSession session) {

        if(!isLogin(model, session)) {
            return "login";
        }else{
            model.addAttribute("title", "EventSoft - Buzón");
            model.addAttribute("pagina", "buzon");
            return "buzon";
        }
    }


    @GetMapping("/nuevo-mensaje")
    public String eventoNuevoMensaje(Model model, HttpSession session) {
        model.addAttribute("title", "EventSoft - Nuevo Mensaje");

        if(!isLogin(model,session)){
            return "login";
        }

        return "nuevo-mensaje";
    }


    @RequestMapping(value = "/crearMensaje", method = RequestMethod.POST)
    public String crearMensaje(HttpSession session, Model model,
            @RequestParam(value = "email") String email, @RequestParam String asunto, @RequestParam String texto) {

        if(!isLogin(model,session)){
            return "login";
        }else {


            if (email.trim().isEmpty() || asunto.trim().isEmpty() || texto.trim().isEmpty()) {
                model.addAttribute("title", "EventSoft - Nuevo Mensaje");
                return "nuevo-mensaje";
            }

            Mensaje mensaje = new Mensaje();
            mensaje.getEmisor().setId(((Usuario) session.getAttribute("usuario")).getId());
            mensaje.getReceptor().setEmail(email);
            mensaje.setAsunto(asunto);
            mensaje.setMensaje(texto);

            Contexto contex = FactoriaComandos.getInstance().crearComando(CREAR_MENSAJE).execute(mensaje);

            if (contex.getEvento() == CREAR_MENSAJE) {
                model.addAttribute("usuario");
                return "buzon";

            } else if (contex.getEvento() == ERROR_CREAR_MENSAJE) {
                return "nuevo-mensaje";
            }
            return "buzon";
        }
    }

    @RequestMapping("buscarMensaje")
    public String buscarMensaje(Model model) {
        //TODO


        return null;
    }

    @RequestMapping("eliminarMensaje")
    public String eliminarMensaje(Model model) {
        //TODO


        return null;
    }

    @RequestMapping("buscarMensajeByEmisor")
    public String buscarMensajeByEmisor(Model model) {
        //TODO


        return null;
    }

    @RequestMapping(value = "buscar-por-receptor", method = RequestMethod.GET)
    public String buscarByReceptor(@RequestParam String query, Model model) {
        //TODO

        return null;
    }

    @RequestMapping(value = "ver/{id}", method = RequestMethod.GET)
    public String ver(@PathVariable("id") Long id, Model model) {
        if (id > 0) {
            Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_MENSAJE).execute(id);

            if (contexto.getEvento() == EventosNegocio.BUSCAR_MENSAJE) {
                model.addAttribute("mensaje", contexto.getDatos());
                return "leer-mensaje";
            } else {
                return "error-500";
            }
        }

        return "redirect:/index";
    }
}