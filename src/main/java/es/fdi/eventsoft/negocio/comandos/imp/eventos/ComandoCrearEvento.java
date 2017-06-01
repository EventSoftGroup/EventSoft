package es.fdi.eventsoft.negocio.comandos.imp.eventos;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.CREAR_EVENTO;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_CREAR_EVENTO;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoCrearEvento implements Comando {

    public Contexto execute(Object datos){

        Long id = FactoriaSA.getInstance().crearSAEventos().crearEvento((Evento) datos);
        return new Contexto((id>0)? CREAR_EVENTO:ERROR_CREAR_EVENTO, id);
    }

}
