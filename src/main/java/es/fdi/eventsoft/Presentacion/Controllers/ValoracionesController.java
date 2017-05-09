package es.fdi.eventsoft.Presentacion.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
@Controller
@RequestMapping("/valoraciones/")
public class ValoracionesController {

    @RequestMapping("crearValoracion")
    public String crearValoracion(Model model) {
        //TODO



        return null;
    }

    @RequestMapping("buscarValoracion")
    public String buscarValoracion(Model model) {
        //TODO



        return null;
    }


    @RequestMapping("eliminarValoracion")
    public String eliminarValoracion(Model model) {
        //TODO



        return null;
    }

    @RequestMapping("buscarValoracionesByUser")
    public String buscarValoracionesByUser(Model model) {
        //TODO


        return null;
    }

}