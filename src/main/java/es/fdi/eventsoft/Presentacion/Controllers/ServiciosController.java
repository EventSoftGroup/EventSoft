package es.fdi.eventsoft.Presentacion.Controllers;

import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(ServiciosController.class);

    @RequestMapping("crearServicio")
    public String crearServicio(Model model) {
        //TODO


        return null;
    }

    @RequestMapping(value = "buscarServicio/{id}", method = RequestMethod.GET)
    public String buscarServicio(@PathVariable("id") Long id, Model model) {
        if (id > 0) {
            Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_SERVICIO).execute(id);

            if (contexto.getEvento() == EventosNegocio.BUSCAR_SERVICIO) {
                model.addAttribute("mensaje", contexto.getDatos());
                return "#";
            } else {
                return "error-500";
            }
        }

        return "redirect:/index";
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
            value = "buscar-por-evento/{idEvento}",
            method = RequestMethod.GET,
            produces = "applicacion/json")
    public @ResponseBody ResponseEntity<Servicio> buscarByEvento(@PathVariable("idEvento") Long idEvento) {
        Contexto contexto;

        if (idEvento > 0) {
            contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_EVENTO).execute(idEvento);
            Evento evento1 = (Evento) contexto.getDatos();
            contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_SERVICIOS_BY_EVENTO).execute(evento1);

            if (contexto.getEvento() == EventosNegocio.BUSCAR_SERVICIOS_BY_EVENTO) {
                log.info(((Evento) contexto.getDatos()).getNombre());
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