package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Usuarios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.BUSCAR_USUARIO;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_BUSCAR_USUARIO;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarUsuarioByID implements Comando {

    public Contexto execute(Object datos){

        Usuario user = FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByID((Long) datos);

        if(user == null){
            return new Contexto(ERROR_BUSCAR_USUARIO, user);
        }



        return new Contexto(BUSCAR_USUARIO, user);
    }

}
