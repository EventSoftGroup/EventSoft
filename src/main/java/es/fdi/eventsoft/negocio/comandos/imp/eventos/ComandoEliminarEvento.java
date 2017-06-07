package es.fdi.eventsoft.negocio.comandos.imp.eventos;
import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoEliminarEvento implements Comando {

    public Contexto execute(Object datos){
        Contexto contex;

        boolean respuesta = FactoriaSA.getInstance().crearSAEventos().eliminarEvento((Long) datos);

        if (respuesta) {
            contex = new Contexto(ELIMINAR_EVENTO, null);
        } else {
            contex = new Contexto(ERROR_ELIMINAR_EVENTO, null);
        }

        return contex;
    }

}
