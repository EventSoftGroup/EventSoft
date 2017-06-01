package es.fdi.eventsoft.negocio.servicios.mensajes;

import es.fdi.eventsoft.negocio.entidades.Mensaje;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAMensajes {

    Long crearMensaje(Mensaje mensajeNuevo) ;

    Mensaje buscarMensaje(Long id);

    boolean eliminarMensaje(Long id);

    List<Mensaje> buscarMensajesByUser(Usuario usuario, boolean emisor);

}
