package es.fdi.eventsoft.negocio.comandos.imp.servicios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import java.util.ArrayList;
import java.util.List;

public class ComandoBuscarServiciosEntreFechas implements Comando {

    public Contexto execute(Object datos){
        List<Servicio> servicios = (List<Servicio>) FactoriaSA.getInstance().crearSAServicios().buscarServiciosEntreFechas((ArrayList<String>) datos);

        if (servicios == null) {
            return new Contexto(EventosNegocio.ERROR_BUSCAR_SERVICIO, servicios);
        }

        return new Contexto(EventosNegocio.BUSCAR_SERVICIOS_ENTRE_FECHAS, servicios);
    }

}