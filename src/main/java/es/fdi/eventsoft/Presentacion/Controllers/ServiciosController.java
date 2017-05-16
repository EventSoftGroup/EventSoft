package es.fdi.eventsoft.Presentacion.Controllers;

import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(
            value = "buscar-por-evento/{evento}",
            method = RequestMethod.GET,
            produces = "applicacion/json")
    public @ResponseBody ResponseEntity<Servicio> buscarByEvento(@PathVariable("evento") String evento) {
        if (!evento.equalsIgnoreCase("")) {
            Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_SERVICIOS_BY_EVENTO).execute(evento);

            if (contexto.getEvento() == EventosNegocio.BUSCAR_SERVICIOS_BY_EVENTO) {
                return new ResponseEntity<>((Servicio) contexto.getDatos(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "buscar-entre-fechas", method = RequestMethod.GET)
    public String buscarEntreFechas(@RequestParam Date fechaIni, @RequestParam Date fechaFin, Model model) {
        // TODO

        return null;
    }

}