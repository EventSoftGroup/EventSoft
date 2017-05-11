package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.Imp;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Empleado;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAUsuarioImp implements SAUsuario{

    public int crearUsuario(Usuario usuarioNuevo) throws ExcepcionNegocio{

        /* Aquí se programaría toda la lógica de Negocio e integración con hibernate */
        int retorno = 1; //Este es el id que me devolvería la base de datos.
        Cliente mi_cliente = null;


        //Comprobaciones de los datos generales.
        if (!usuarioNuevo.getDireccion().equalsIgnoreCase("") &&
                !usuarioNuevo.getLocalidad().equalsIgnoreCase("") &&
                !usuarioNuevo.getProvincia().equalsIgnoreCase("")
                ) {
            System.out.println("dirección, localidad y provincia rellenas");
        }
        System.out.println("datos del codigo postal:" + usuarioNuevo.getCodigoPostal());

        if (usuarioNuevo instanceof Cliente) {
            mi_cliente = (Cliente) usuarioNuevo;

            FachadaIntegracion<Cliente> fachadaIntegracion = FachadaIntegracion.newInstance(Cliente.class);
            fachadaIntegracion.alta(mi_cliente);

            System.out.println("Elemenento persistido correctamente");

            //Realizamos las comprobaciones de los datos.

        } else {
            System.out.println("No es de tipo cliente");
        }

        return retorno;
    }

    @Override
    public Usuario buscarUsuario(Usuario usuarioNuevo) throws ExcepcionNegocio {
        //TODO
        return null;
    }

    @Override
    public int eliminarUsuario(Usuario usuarioNuevo) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public int modificarUsuario(Usuario usuarioNuevo) throws ExcepcionNegocio {
        //TODO
        return 0;
    }
}
