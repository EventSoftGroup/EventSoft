package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAMensajes {

    Long crearMensaje(Mensaje mensajeNuevo) ;

    Mensaje buscarMensaje(Long id);

    boolean eliminarMensaje(Long id);

    List<Mensaje> buscarMensajesByUser(Usuario usuario, boolean emisor);

    Long totalMensajes();

}
