package es.fdi.eventsoft.negocio.comandos.imp.servicios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.BUSCAR_SERVICIOS_BY_TIPO_SERVICIO;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_BUSCAR_SERVICIOS;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarServiciosByTipoServicio implements Comando {

    public Contexto execute(Object datos){

        List<Servicio> listaServicios = FactoriaSA.getInstance().crearSAServicios().buscarServiciosByTipoServicio((Servicio.TiposServicio) datos);

        return new Contexto((listaServicios != null) ? BUSCAR_SERVICIOS_BY_TIPO_SERVICIO : ERROR_BUSCAR_SERVICIOS, listaServicios);

    }

}