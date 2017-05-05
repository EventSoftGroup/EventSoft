package es.fdi.eventsoft.negocio.ServiciosAplicacion.ServicioAplicacion_Usuario;
import es.fdi.eventsoft.negocio.__Usuario.TCliente;
import es.fdi.eventsoft.negocio.__Usuario.TUsuario;
import es.fdi.eventsoft.negocio.__excepcionNegocio.ExcepcionNegocio;

/**
 * Created by Tomas on 29/04/17.
 */
public class SAUsuarioImp implements SAUsuario {
    @Override
    public int crearUsuario(TUsuario usuarioNuevo) throws ExcepcionNegocio{

        /* Aquí se programaría toda la lógica de negocio e integración con hibernate */
        int retorno = 1; //Este es el id que me devolvería la base de datos.
        TCliente mi_cliente = null;


        //Comprobaciones de los datos generales.
        if (!usuarioNuevo.getDireccion().equalsIgnoreCase("") &&
                !usuarioNuevo.getLocalidad().equalsIgnoreCase("") &&
                !usuarioNuevo.getProvincia().equalsIgnoreCase("")
                ) {
            System.out.println("dirección, localidad y provincia rellenas");
        }
        System.out.println("datos del codigo postal:" + usuarioNuevo.getCodigoPostal());

        if (usuarioNuevo instanceof TCliente) {
            mi_cliente = (TCliente) usuarioNuevo;



            //Realizamos las comprobaciones de los datos.

        } else {
            System.out.println("No es de tipo cliente");
        }

        return retorno;
    }
}
