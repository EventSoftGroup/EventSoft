package es.fdi.eventsoft.negocio.comandos.imp.eventos;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import javafx.util.Pair;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoAnadirServiciosAEvento implements Comando {

    public Contexto execute(Object datos){
        Pair<Long, List<Long>> par = (Pair<Long, List<Long>>) datos;
        EventosNegocio evento = FactoriaSA.getInstance().crearSAEventos().añadirServiciosAEvento(par.getKey(), par.getValue());
        return new Contexto(evento, null);
    }

}
