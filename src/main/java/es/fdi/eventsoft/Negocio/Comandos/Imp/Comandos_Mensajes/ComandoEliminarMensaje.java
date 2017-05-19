package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Mensajes;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoEliminarMensaje implements Comando {

    public Contexto execute(Object datos){
        FactoriaSA.getInstance().crearSAMensajes().eliminarMensaje((Long) datos);

        return new Contexto(EventosNegocio.ELIMINAR_MENSAJE, true);
    }

}
