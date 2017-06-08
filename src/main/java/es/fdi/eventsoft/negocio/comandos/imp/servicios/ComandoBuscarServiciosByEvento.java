package es.fdi.eventsoft.negocio.comandos.imp.servicios;
import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarServiciosByEvento implements Comando {

    public Contexto execute(Object datos){
        List<Servicio> servicios = FactoriaSA.getInstance().crearSAServicios().buscarServiciosByEvento((Evento) datos);

        if (servicios == null) {
            return new Contexto(EventosNegocio.ERROR_BUSCAR_SERVICIO, null);
        }

        return new Contexto(EventosNegocio.BUSCAR_SERVICIOS_BY_EVENTO, servicios);
    }

}