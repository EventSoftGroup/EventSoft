package es.fdi.eventsoft.negocio.servicios.usuarios;

import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAUsuario {

    EventosNegocio crearUsuario(Usuario usuarioNuevo);

    Usuario buscarUsuarioByID(Long id);

    public Usuario buscarUsuarioByEmail(String email);

    public EventosNegocio eliminarUsuario(Usuario usuarioEliminar);

    public boolean modificarUsuario(Usuario usuarioNuevo);

    List<Usuario> listarUsuariosByTipo(Class<? extends Usuario> tipoUsuario);

}
