package es.fdi.eventsoft.Presentacion.Controllers;

import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
@Controller
@RequestMapping("/mensajes/")
public class MensajesController {

    @RequestMapping(value = "leer", method = RequestMethod.GET)
    public String leer(@RequestAttribute("Mensaje")Mensaje mensaje, Model model) {
        model.addAttribute("mensaje", mensaje);

        return "leer-mensaje";
    }

    @RequestMapping("crearMensaje")
    public String crearValoracion(Model model) {
        //TODO


        return null;
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