package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarServicio implements Comando {

    public Contexto execute(Object datos){
        Servicio servicio = FactoriaSA.getInstance().crearSAServicios().buscarServicio((Long) datos);

        if (servicio == null) {
            return new Contexto(EventosNegocio.ERROR_BUSCAR_SERVICIO, servicio);
        }

        return new Contexto(EventosNegocio.BUSCAR_SERVICIO, servicio);
    }

}
