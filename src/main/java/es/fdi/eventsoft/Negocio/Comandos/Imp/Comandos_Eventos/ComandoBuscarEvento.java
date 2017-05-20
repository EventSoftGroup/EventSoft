package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Eventos;
import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarEvento implements Comando {

    public Contexto execute(Object datos){
        Evento evento = FactoriaSA.getInstance().crearSAEventos().buscarEvento((Long) datos);

        return new Contexto(EventosNegocio.BUSCAR_EVENTO, evento);
    }

}
