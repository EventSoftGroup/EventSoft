package es.fdi.eventsoft.presentacion.controllers;


import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Organizador;
import es.fdi.eventsoft.negocio.entidades.usuario.Proveedor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;


@Controller
@RequestMapping("/administracion/")
public class AdminController {

    private Logger log = LoggerFactory.getLogger(ServiciosController.class);

    @RequestMapping("admin")
    public String home(Model model){

        long time_start, time_end;
        time_start = System.currentTimeMillis();

        //Flujo de array de objetos que contienen los parametros para los 6 hilos que se lanzaran
        Stream<Object[]> flujo1 = Stream.of(
                //param1 = comando, param2 = param del comando, param3 = nombre del modelAttribute
                new Object[]{LISTAR_USUARIOS, Cliente.class, "listaClinetes"},
                new Object[]{LISTAR_USUARIOS, Proveedor.class, "listaProveedores"},
                new Object[]{LISTAR_USUARIOS, Organizador.class, "listaOrganizadores"},
                new Object[]{LISTAR_SERVICIOS, null, "listaServicios"},
                new Object[]{LISTAR_EVENTOS, null, "listaEventos"},
                new Object[]{COUNT_MENSAJES, null, "numTotalMensajes"});

        //Pool de Threads
        ExecutorService executor = Executors.newCachedThreadPool();

        //Stream, se crean los hilos y se lanzan con el pool
        flujo1.map(
                (param) -> {
                    return (Runnable) () -> {
                        Contexto contex = FactoriaComandos.getInstance().crearComando((EventosNegocio) param[0]).execute(param[1]);
                        if (contex.getEvento() != param[0]) {
                            model.addAttribute((String) param[2], null);
                        } else {
                            model.addAttribute((String) param[2], contex.getDatos());
                        }
                    };
                }).forEach(executor::execute);

        //Se da la orden de acabar con el pool al terminar
        executor.shutdown();

        try {

            if(executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                time_end = System.currentTimeMillis();
                System.out.println("The task has taken "+ ( time_end - time_start ) +" milliseconds");


                model.addAttribute("title", "EventSoft");
                model.addAttribute("pagina", "admin");
                return "admin";
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            return "login";
        }
        return "login";
    }
}