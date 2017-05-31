package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.BUSCAR_SERVICIOS_BY_TIPO_SERVICIO;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_BUSCAR_SERVICIOS;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarServiciosByTipoServicio implements Comando {

    public Contexto execute(Object datos){

        List<Servicio> listaServicios = FactoriaSA.getInstance().crearSAServicios().buscarServiciosByTipoServicio((Servicio.TiposServicio) datos);

        return new Contexto((listaServicios != null) ? BUSCAR_SERVICIOS_BY_TIPO_SERVICIO : ERROR_BUSCAR_SERVICIOS, listaServicios);

    }

}