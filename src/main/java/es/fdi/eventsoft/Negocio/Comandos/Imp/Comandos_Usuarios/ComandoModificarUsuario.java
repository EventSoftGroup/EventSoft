package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Usuarios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoModificarUsuario implements Comando {

    public Contexto execute(Object datos){
        FactoriaSA.getInstance().crearSAUsuarios().modificarUsuario((Usuario) datos);

        return new Contexto(EventosNegocio.MODIFICAR_USUARIO, true);
    }

}