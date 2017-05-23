package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios;
import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import java.util.ArrayList;
import java.util.Date;
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