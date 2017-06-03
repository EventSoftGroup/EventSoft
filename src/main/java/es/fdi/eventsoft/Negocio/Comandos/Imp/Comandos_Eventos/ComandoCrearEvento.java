package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Eventos;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.CREAR_EVENTO;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_CREAR_EVENTO;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoCrearEvento implements Comando {

    public Contexto execute(Object datos){
        Long id;
        try {
            id = FactoriaSA.getInstance().crearSAEventos().crearEvento((Evento) datos);
        }catch (NullPointerException e){
            id = -1L;
        }

        return new Contexto((id>0)? CREAR_EVENTO:ERROR_CREAR_EVENTO, id);
    }

}
