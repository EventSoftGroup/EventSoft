package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Mensajes;
import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

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
