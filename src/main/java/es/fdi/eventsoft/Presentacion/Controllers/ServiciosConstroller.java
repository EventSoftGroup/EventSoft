package es.fdi.eventsoft.Presentacion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
@Controller
@RequestMapping("/servicios/")
public class ServiciosConstroller {


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



    @RequestMapping("buscarServiciosByEvento")
    public String buscarServiciosByEvento(Model model) {
        //TODO


        return null;
    }




    @RequestMapping("buscarServiciosEntreFechas")
    public String buscarServiciosEntreFechas(Model model) {
        //TODO

        return null;
    }

}