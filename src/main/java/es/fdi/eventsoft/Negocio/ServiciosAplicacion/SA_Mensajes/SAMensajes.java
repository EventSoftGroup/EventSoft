package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAMensajes {

    Long crearMensaje(Mensaje mensajeNuevo) ;

<<<<<<< HEAD
    Mensaje buscarMensaje(Mensaje mensaje) throws ExcepcionNegocio;
=======
    public Mensaje buscarMensaje(Long id);
>>>>>>> bcb8b06ffc6f399d332fdab62f593e7d686c2045

    int eliminarMensaje(Mensaje mensaje) throws ExcepcionNegocio;

    List<Mensaje> buscarMensajesByUser(Usuario usuario, boolean emisor) throws ExcepcionNegocio;

}
