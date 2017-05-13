package es.fdi.eventsoft.Presentacion.Controllers;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
}