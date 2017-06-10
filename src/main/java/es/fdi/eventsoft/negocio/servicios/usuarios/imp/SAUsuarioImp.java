package es.fdi.eventsoft.negocio.servicios.usuarios.imp;


import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.usuarios.SAUsuario;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;

@Service
public class SAUsuarioImp implements SAUsuario {

    public EventosNegocio crearUsuario(Usuario usuarioNuevo){

        Object result = null;
        FachadaIntegracion integra = null;

            //si no existe ya el correo...
            if (buscarUsuarioByEmail(usuarioNuevo.getEmail()) == null) {

                usuarioNuevo.setEstado(Usuario.EstadosUsuario.ACTIVO);

                integra = FachadaIntegracion.newInstance(Usuario.class);
                integra.begin();
                result = integra.alta(usuarioNuevo);
                integra.commit();

            }else{
                return EventosNegocio.EMAIL_YA_EXISTENTE;
            }

        return (result!=null) ? USUARIO_CREADO : ERROR_CREAR_USUARIO;
    }

    @Override
    public Usuario buscarUsuarioByID(Long id) {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(Usuario.class);

        integra.begin();
        Usuario user = (Usuario) integra.consulta(id);
        integra.commit();

        return user;
    }

    @Override
    public EventosNegocio eliminarUsuario(Usuario usuarioEliminar) {

        FachadaIntegracion integra = null;
        boolean result = false;


        try {

            Usuario aborrar = new Usuario();
            //Se elimina solo si existe el correo
            if (usuarioEliminar.getEmail() != null){
                aborrar = buscarUsuarioByEmail(usuarioEliminar.getEmail());
            } else {
                aborrar = buscarUsuarioByID(usuarioEliminar.getId());
            }

            if (aborrar != null) {
                integra = FachadaIntegracion.newInstance(Usuario.class);

                integra.begin();
                result = integra.baja(aborrar.getId());
                integra.commit();
            }


        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return (result == true) ? ELIMINAR_USUARIO : ERROR_ELIMINAR_USUARIO;
    }

    public Usuario buscarUsuarioByEmail(String email) {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(Usuario.class);

        integra.begin();
        List list = integra.ejecutarNamedQuery("Usuario.buscarPorEmail", Arrays.asList(new Pair<>("email", email)));
        integra.commit();

        return (list.isEmpty()) ? null : (Usuario) (list.iterator().next());
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Usuario.class);

        fachadaIntegracion.begin();
        fachadaIntegracion.modifica(usuario);
        fachadaIntegracion.commit();

        return true;
    }

    @Override
    public List<Usuario> listarUsuariosByTipo(Class<? extends Usuario> tipoUsuario) {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(tipoUsuario);
        List lista = null;

        integra.begin();
        lista = integra.listado();
        integra.commit();

        return lista;
    }
}
