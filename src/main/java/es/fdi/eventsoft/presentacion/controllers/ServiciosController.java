package es.fdi.eventsoft.presentacion.controllers;

import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Proveedor;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;

@Controller
@RequestMapping("/servicios")
public class ServiciosController {

    private Logger log = LoggerFactory.getLogger(ServiciosController.class);

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crear(
            @RequestParam("nombreServicio") String nombre,
            @RequestParam("listaServicios") Servicio.TiposServicio tipoElegido,
            @RequestParam("descripcion") String descripcion,
            HttpSession session,
            Model model
    ) {

        Contexto contexto;
        //Creamos la fecha de registro
        Date fechaRegistro = new Date();
        //Creamos el nuevo servicio con sus datos
        Servicio servicio = new Servicio(tipoElegido, nombre, descripcion, fechaRegistro, (Proveedor) session.getAttribute("usuario"));
        //Lo insertamos en la BBDD
        contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_SERVICIO).execute(servicio);

        if (contexto.getEvento() == EventosNegocio.CREAR_SERVICIO) {//Si el servicio se ha creado correctamente
            //Buscamos de nuevo el proveedor del servicio para actualizar la sesion
            contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_USUARIO_BY_ID).execute(((Proveedor) session.getAttribute("usuario")).getId());
            //Actualizamos la sesion
            session.setAttribute("usuario", (Usuario) contexto.getDatos());
            //Actualizamos el modelo
            model.addAttribute("usuarioAModificar", session.getAttribute("usuario"));
            model.addAttribute("listaTiposServicio", Servicio.TiposServicio.values());

            return "perfil-usuario";
        } else {
            return "error-500";
        }
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/eliminar/{idP}/{idS}", method = RequestMethod.GET)
    public String eliminarServicio(@PathVariable("idP") Long idProv, @PathVariable("idS") Long idServ, Model model) {
        if(idServ > 0) {

            Contexto contex = FactoriaComandos.getInstance().crearComando(ELIMINAR_SERVICIO).execute(idServ);

            if (contex.getEvento() == ELIMINAR_SERVICIO) {
                contex = FactoriaComandos.getInstance().crearComando(BUSCAR_SERVICIOS_BY_PROVEEDOR).execute(idProv);

                if (contex.getEvento() == BUSCAR_SERVICIOS_BY_PROVEEDOR) {
                    model.addAttribute("listaServicios", contex.getDatos());
                    return "Servicios-Ofertados";
                }

            } else {
                return "error-500";
            }
        }
        else return "error-500";
            /*
            if (contex.getEvento() == ELIMINAR_SERVICIO) {
                return new ResponseEntity<>((String) contex.getDatos(), HttpStatus.OK);
            } else if(contex.getEvento() == ERROR_ELIMINAR_SERVICIO){
                return new ResponseEntity<>((String) contex.getDatos(), HttpStatus.NOT_FOUND);
            }
            else if(contex.getEvento() == ERROR_SERVICIO_ASOCIADO_A_EVENTO){
                return new ResponseEntity<>((String) contex.getDatos(), HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        */
        return "redirect:/index";
    }

    @RequestMapping("/modificar")
    public String modificarServicio(Model model) {
        //TODO


        return null;
    }

    @RequestMapping("/buscar/por-proveedor/{id}")
    public String buscarServiciosByProveedor(@PathVariable("id") Long id,  Model model) {

        if (id > 0) {
            Contexto contex = FactoriaComandos.getInstance().crearComando(BUSCAR_SERVICIOS_BY_PROVEEDOR).execute(id);

            if (contex.getEvento() == BUSCAR_SERVICIOS_BY_PROVEEDOR) {
                model.addAttribute("listaServicios", contex.getDatos());
                return "Servicios-Ofertados";
            } else {
                return "error-500";
            }
        }

        return "redirect:/index";
    }

    @RequestMapping(value = "/buscar/por-tipo-servicio/{tipoServicio}",  method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<List<Servicio>> buscarServiciosByTipoServicio(@PathVariable String tipoServicio) {

        try {
            if (Arrays.asList(Servicio.TiposServicio.values()).contains(Servicio.TiposServicio.valueOf(tipoServicio.toUpperCase()))) {
                System.out.println(tipoServicio + " existe en el sistema.");

                Contexto contex = FactoriaComandos.getInstance().crearComando(BUSCAR_SERVICIOS_BY_TIPO_SERVICIO).execute(Servicio.TiposServicio.valueOf(tipoServicio));

                if (contex.getEvento() == BUSCAR_SERVICIOS_BY_TIPO_SERVICIO) {
                    return new ResponseEntity<>((List<Servicio>) contex.getDatos(), HttpStatus.OK);
                } else if (contex.getEvento() == ERROR_BUSCAR_SERVICIOS) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }

            } else {
                System.out.println(tipoServicio + " no existe en el sistema.");
            }
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = "/buscar/por-evento/{idEvento}",
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

    @RequestMapping(
            value = "/buscar/entre-fechas/{fechaIni}/{fechaFin}",
            method = RequestMethod.GET,
            produces = "application/json")
    public @ResponseBody ResponseEntity<Servicio> buscarEntreFechas(@PathVariable("fechaIni") String fechaIni, @PathVariable("fechaFin") String fechaFin) {
        Contexto contexto;
        ArrayList<String> fechas = new ArrayList();
        fechas.add(fechaIni);
        fechas.add(fechaFin);

        if (fechaIni != null && fechaFin != null) {
            contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_SERVICIOS_ENTRE_FECHAS).execute(fechas);

            if (contexto.getEvento() == EventosNegocio.BUSCAR_SERVICIOS_ENTRE_FECHAS) {
                log.info(((Servicio) contexto.getDatos()).getNombre());
                return new ResponseEntity<>((Servicio) contexto.getDatos(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}