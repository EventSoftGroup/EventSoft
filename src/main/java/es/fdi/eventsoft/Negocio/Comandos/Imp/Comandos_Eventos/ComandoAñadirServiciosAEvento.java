package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Eventos;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import javafx.util.Pair;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoAñadirServiciosAEvento implements Comando {

    public Contexto execute(Object datos){
        Pair<Long, List<Long>> par = (Pair<Long, List<Long>>) datos;
        EventosNegocio evento = FactoriaSA.getInstance().crearSAEventos().añadirServiciosAEvento(par.getKey(), par.getValue());
        return new Contexto(evento, null);
    }

}
