package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Mensajes;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ELIMINAR_MENSAJE;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_ELIMINAR_MENSAJE;

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
