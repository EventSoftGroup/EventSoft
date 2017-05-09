package es.fdi.eventsoft.Presentacion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
@Controller
@RequestMapping("/mensajes/")
public class MensajesController {


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





    @RequestMapping("buscarMensajeByReceptor")
    public String buscarMensajeByReceptor(Model model) {
        //TODO


        return null;
    }
}