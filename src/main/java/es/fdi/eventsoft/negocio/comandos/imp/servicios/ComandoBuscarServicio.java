package es.fdi.eventsoft.negocio.comandos.imp.servicios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.BUSCAR_SERVICIO;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_BUSCAR_SERVICIO;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarServicio implements Comando {

    public Contexto execute(Object datos){
        Servicio servicio = FactoriaSA.getInstance().crearSAServicios().buscarServicio((Long) datos);
        return new Contexto((servicio != null)? BUSCAR_SERVICIO:ERROR_BUSCAR_SERVICIO, servicio);
    }

}
