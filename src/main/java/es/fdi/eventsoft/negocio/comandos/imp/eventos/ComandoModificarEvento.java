package es.fdi.eventsoft.negocio.comandos.imp.eventos;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoModificarEvento implements Comando {

    public Contexto execute(Object datos){
        //TODO
        Contexto contex;

        boolean result = FactoriaSA.getInstance().crearSAEventos().modificarEvento((Evento) datos);
        if(result == true){
            contex = new Contexto(EventosNegocio.MODIFICAR_EVENTO, datos);
        }
        else{
            contex = new Contexto(EventosNegocio.ERROR_MODIFICAR_EVENTO, null);
        }

        return contex;
    }

}