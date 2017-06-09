package es.fdi.eventsoft.negocio.comandos.imp.eventos;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

/**
 * Created by fernando on 09/06/2017.
 */
public class ComandoBuscarEventoParaModificar implements Comando {

    public Contexto execute(Object datos){
        Evento evento = FactoriaSA.getInstance().crearSAEventos().buscarEventoParaModificar((Long) datos);

        return new Contexto(EventosNegocio.BUSCAR_EVENTO, evento);
    }

}
