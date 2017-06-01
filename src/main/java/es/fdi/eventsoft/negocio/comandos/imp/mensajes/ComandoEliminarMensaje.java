package es.fdi.eventsoft.negocio.comandos.imp.mensajes;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ELIMINAR_MENSAJE;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_ELIMINAR_MENSAJE;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoEliminarMensaje implements Comando {

    public Contexto execute(Object datos){

        Contexto contex;

        boolean respuesta = FactoriaSA.getInstance().crearSAMensajes().eliminarMensaje((Long) datos);
        (contex = new Contexto()).setEvento(respuesta ? ELIMINAR_MENSAJE : ERROR_ELIMINAR_MENSAJE);

        return contex;
    }
}
