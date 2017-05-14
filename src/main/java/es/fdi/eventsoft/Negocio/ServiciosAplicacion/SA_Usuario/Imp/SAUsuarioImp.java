package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.Imp;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAUsuarioImp implements SAUsuario{

    public boolean crearUsuario(Usuario usuarioNuevo){

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
        }

        integra.commit();

    }catch (Exception e){
        System.err.println(e.getMessage());
        e.printStackTrace();
    }

        return (result!=null) ? true : false;
    }

    @Override
    public Usuario buscarUsuario(Usuario usuarioNuevo) throws ExcepcionNegocio {
        //TODO
        return null;
    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws ExcepcionNegocio {
        FachadaIntegracion<Usuario> fachadaIntegracion = FachadaIntegracion.newInstance(Usuario.class);
        fachadaIntegracion.baja(usuario.getId());
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws ExcepcionNegocio {
        FachadaIntegracion<Usuario> fachadaIntegracion = FachadaIntegracion.newInstance(Usuario.class);
        fachadaIntegracion.modifica(usuario);
    }
}
