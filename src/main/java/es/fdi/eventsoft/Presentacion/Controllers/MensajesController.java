package es.fdi.eventsoft.Presentacion.Controllers;

import com.sun.org.apache.regexp.internal.RE;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import javafx.util.Pair;
import org.hibernate.service.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;
import javax.servlet.http.HttpSession;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.*;
import static es.fdi.eventsoft.Presentacion.Controllers.HomeController.isLogin;

import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;

import java.util.List;


/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
@Controller
@RequestMapping("/mensajes/")
public class MensajesController {

    @GetMapping("/buzon")
    public String eventoBuzon(Model model, HttpSession session) {
        long time_start, time_end;
        time_start = System.currentTimeMillis();

        if(!isLogin(model,session)){
            return "login";
        }else {
            final Contexto[] contexMensajesEnviados = new Contexto[1];
            final Contexto[] contexMensajesRecibidos = new Contexto[1];
            Usuario user = (Usuario) session.getAttribute("usuario");

            //Threads para buscar mensajes enviados y recibidos del usuarios logueado
            Thread hiloBusquedaEnviados = new Thread(() -> contexMensajesEnviados[0] = FactoriaComandos.getInstance().crearComando(BUSCAR_MENSAJES_BY_USER).execute(new Pair<>(user, true)));
            Thread hiloBusquedaRecibidos = new Thread(() -> contexMensajesRecibidos[0] = FactoriaComandos.getInstance().crearComando(BUSCAR_MENSAJES_BY_USER).execute(new Pair<>(user, false)));

            hiloBusquedaEnviados.start();
            hiloBusquedaRecibidos.start();

            try {
                hiloBusquedaEnviados.join();
                hiloBusquedaRecibidos.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "login";
            }

            if (contexMensajesEnviados[0].getEvento() == ERROR_BUSCAR_USUARIO) {
                return "login";
            } else if (contexMensajesEnviados[0].getEvento() == BUSCAR_MENSAJES_BY_USER) {

                user.setMensajes_enviados((List) contexMensajesEnviados[0].getDatos());

                if (contexMensajesRecibidos[0].getEvento() == ERROR_BUSCAR_USUARIO) {
                    return "login";
                } else if (contexMensajesRecibidos[0].getEvento() == BUSCAR_MENSAJES_BY_USER) {

                    user.setMensajes_recibidos((List) contexMensajesRecibidos[0].getDatos());

                    session.setAttribute("usuario", user);
                    model.addAttribute("title", "EventSoft - Buzón");
                    model.addAttribute("pagina", "buzon");

                    time_end = System.currentTimeMillis();
                    System.out.println("The task has taken "+ ( time_end - time_start ) +" milliseconds");
                    return "buzon";
                }
            }
            return "login";
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
    public String crearMensaje(
            HttpSession session,
            Model model,
            @RequestParam(value = "email") String email,
            @RequestParam String asunto,
            @RequestParam String texto) {

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

    @RequestMapping(value = "eliminar", method = RequestMethod.DELETE)
    public String eliminarMensaje(@PathVariable("id") Long id, Model model) {
        if (id > 0) {
            Contexto contexto = FactoriaComandos.getInstance().crearComando(ELIMINAR_MENSAJE).execute(id);

            if (contexto.getEvento() == ELIMINAR_MENSAJE) {
                return "buzon";
            } else {
                return "error-500";
            }
        }

        return "redirect:/index";
    }

    @RequestMapping(value = "buscarMensajeByEmisor", method = RequestMethod.POST)
    public String buscarMensajeByEmisor(
            @RequestParam Usuario emisor,
            Model model,
            HttpSession session) {
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