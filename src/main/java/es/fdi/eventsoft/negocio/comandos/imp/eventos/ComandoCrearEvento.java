package es.fdi.eventsoft.negocio.comandos.imp.eventos;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.CREAR_EVENTO;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_CLIENTE_ERRONEO;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_CREAR_EVENTO;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoCrearEvento implements Comando {

    public Contexto execute(Object datos){
        EventosNegocio event = null;

        Long id = FactoriaSA.getInstance().crearSAEventos().crearEvento((Evento) datos);

        if (id == -1L)
            event = ERROR_CREAR_EVENTO;
        else if(id == -2L)
            event = ERROR_CLIENTE_ERRONEO;
        else if(id == -3L)
            event = EventosNegocio.ERROR_ORGANIZADOR_ERRONEO;


        return new Contexto((id>0)? CREAR_EVENTO:event, id);
    }

}
