package es.fdi.eventsoft.negocio.comandos.imp.mensajes;
import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Mensaje;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarMensaje implements Comando {

    public Contexto execute(Object datos){
        Mensaje mensaje = FactoriaSA.getInstance().crearSAMensajes().buscarMensaje((Long) datos);

        if (mensaje == null) {
            return new Contexto(EventosNegocio.ERROR_BUSCAR_MENSAJE, mensaje);
        }

        return new Contexto(EventosNegocio.BUSCAR_MENSAJE, mensaje);
    }

}
