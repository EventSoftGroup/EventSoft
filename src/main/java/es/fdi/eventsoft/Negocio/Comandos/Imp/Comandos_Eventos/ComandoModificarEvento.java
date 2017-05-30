package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Eventos;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

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