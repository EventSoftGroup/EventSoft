package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.Imp;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.*;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAUsuarioImp implements SAUsuario{

    public EventosNegocio crearUsuario(Usuario usuarioNuevo){

        Object result = null;
        FachadaIntegracion integra = null;

        if (usuarioNuevo instanceof Cliente) {
            integra = FachadaIntegracion.newInstance(Cliente.class);
        } else if (usuarioNuevo instanceof Proveedor) {
            integra = FachadaIntegracion.newInstance(Proveedor.class);

        } else if (usuarioNuevo instanceof Organizador) {
            integra = FachadaIntegracion.newInstance(Organizador.class);
        }

        try {
            integra.begin();
            //si no existe ya el correo...
            if (!(integra.ejecutarQuery("from Usuario where email='" + usuarioNuevo.getEmail() + "'").size() > 0)) {
                usuarioNuevo.setEstado(Usuario.EstadosUsuario.ACTIVO);
                result = integra.alta(usuarioNuevo);
            }else{
                return EventosNegocio.EMAIL_YA_EXISTENTE;
            }

            integra.commit();

        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
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

        if (usuarioEliminar instanceof Cliente) {
            integra = FachadaIntegracion.newInstance(Cliente.class);
        } else if (usuarioEliminar instanceof Proveedor) {
            integra = FachadaIntegracion.newInstance(Proveedor.class);

        } else if (usuarioEliminar instanceof Organizador) {
            integra = FachadaIntegracion.newInstance(Organizador.class);
        }

        try {
            integra.begin();
            //Se elimina solo si existe el correo
            Usuario aborrar = buscarUsuarioByEmail(usuarioEliminar.getEmail());
            if (aborrar != null) {
                result = integra.baja(aborrar.getId());
            }

            integra.commit();

        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return (result == true) ? ELIMINAR_USUARIO : ERROR_ELIMINAR_USUARIO;
    }

    public Usuario buscarUsuarioByEmail(String email) {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(Usuario.class);

        integra.begin();
        List list = integra.ejecutarQuery("from Usuario where email='" + email + "'");
        integra.commit();

        return (list.isEmpty()) ? null : (Usuario) (list.iterator().next());
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws ExcepcionNegocio {
        FachadaIntegracion<Usuario> fachadaIntegracion = FachadaIntegracion.newInstance(Usuario.class);
        fachadaIntegracion.modifica(usuario);
    }
}
