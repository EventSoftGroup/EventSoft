package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.Imp;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import javax.management.Query;
import java.util.ArrayList;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAUsuarioImp implements SAUsuario{

    public int crearUsuario(Usuario usuarioNuevo) throws ExcepcionNegocio{


        int retorno = 1; //Este es el id que me devolvería la base de datos.
        Cliente mi_cliente = null;
        FachadaIntegracion integra = null;

        integra = FachadaIntegracion.newInstance(Usuario.class);
        int existe = ((ArrayList) integra.ejecutarQuery("from Usuario where email='" + usuarioNuevo.getEmail() + "'")).size();

        if(existe<0){

            if (usuarioNuevo instanceof Cliente) {
                mi_cliente = (Cliente) usuarioNuevo;



            } else if (usuarioNuevo instanceof Proveedor) {
                integra = FachadaIntegracion.newInstance(Proveedor.class);

            } else if (usuarioNuevo instanceof Organizador) {
                integra = FachadaIntegracion.newInstance(Organizador.class);

            }

            integra.begin();


            integra.commit();

        }




        return retorno;
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
