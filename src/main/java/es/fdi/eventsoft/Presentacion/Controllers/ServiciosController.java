package es.fdi.eventsoft.Presentacion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
@Controller
@RequestMapping("/servicios/")
public class ServiciosController {


    @RequestMapping("crearServicio")
    public String crearServicio(Model model) {
        //TODO


        return null;
    }

    @RequestMapping("buscarServicio")
    public String buscarServicio(Model model) {
        //TODO


        return null;
    }

    @RequestMapping("eliminarServicio")
    public String eliminarServicio(Model model) {
        //TODO


        return null;
    }

    @RequestMapping("modificarServicio")
    public String modificarServicio(Model model) {
        //TODO


        return null;
    }

    @RequestMapping("buscarServiciosByProveedor")
    public String buscarServiciosByProveedor(Model model) {
        //TODO


        return null;
    }

    @RequestMapping(value = "buscar-por-evento", method = RequestMethod.GET)
    public String buscarByEvento(@RequestParam String evento, Model model) {
        // TODO

        return null;
    }

    @RequestMapping(value = "buscar-entre-fechas", method = RequestMethod.GET)
    public String buscarEntreFechas(@RequestParam Date fechaIni, @RequestParam Date fechaFin, Model model) {
        // TODO

        return null;
    }

}