package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Usuarios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoEliminarUsuario implements Comando {

    public Contexto execute(Object datos){
        //TODO
        //return new Contexto(FactoriaSA.getInstance().crearSAUsuarios().eliminarUsuario((Usuario)datos), null);
        boolean respuesta = FactoriaSA.getInstance().crearSAUsuarios().eliminarUsuario((Usuario) datos);
        if (respuesta) {
            System.out.println("Elemento eliminado");
        } else {
            System.out.println("Error al eliminar");
        }
        return new Contexto(EventosNegocio.ELIMINAR_USUARIO, respuesta);

    }

}
