package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario;

import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAUsuario {

    EventosNegocio crearUsuario(Usuario usuarioNuevo);

    Usuario buscarUsuarioByID(Long id);

    public Usuario buscarUsuarioByEmail(String email);

    public EventosNegocio eliminarUsuario(Usuario usuarioEliminar);

    public boolean modificarUsuario(Usuario usuarioNuevo);

}
