package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAMensajes {

    public int crearMensaje(Mensaje mensajeNuevo) throws ExcepcionNegocio;

    public Mensaje buscarMensaje(Long id);

    public int eliminarMensaje(Mensaje mensaje) throws ExcepcionNegocio;

    public List<Mensaje> buscarMensajesByUser(Usuario usuario, boolean emisor) throws ExcepcionNegocio;

}
