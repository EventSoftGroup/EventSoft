package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.Imp;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

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
    public boolean eliminarUsuario(Usuario usuarioEliminar) {

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
            System.out.println(integra.ejecutarQuery("from Usuario where email='" + usuarioEliminar.getEmail() + "'"));
            /*if ((integra.ejecutarQuery("from Usuario where email='" + usuarioEliminar.getEmail() + "'").size() > 0)) {
                integra.ejecutarQuery("from Usuario where email");
                System.out.println("voy a eliminar");
                result = integra.baja(1L);
            }*/

            integra.commit();

        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Devuelvo el resultado: " + result);
        return (result);
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws ExcepcionNegocio {
        FachadaIntegracion<Usuario> fachadaIntegracion = FachadaIntegracion.newInstance(Usuario.class);
        fachadaIntegracion.modifica(usuario);
    }
}
