package es.fdi.eventsoft.negocio.comandos.imp.eventos;
        import es.fdi.eventsoft.negocio.comandos.Comando;
        import es.fdi.eventsoft.negocio.comandos.Contexto;
        import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
        import es.fdi.eventsoft.negocio.entidades.Evento;
        import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarEvento implements Comando {

    public Contexto execute(Object datos){
        Evento evento = FactoriaSA.getInstance().crearSAEventos().buscarEvento((Long) datos);

        return new Contexto(EventosNegocio.BUSCAR_EVENTO, evento);
    }

}
