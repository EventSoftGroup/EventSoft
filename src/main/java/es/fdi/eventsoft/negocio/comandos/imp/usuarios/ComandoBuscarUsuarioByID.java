package es.fdi.eventsoft.negocio.comandos.imp.usuarios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.BUSCAR_USUARIO_BY_ID;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_BUSCAR_USUARIO;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarUsuarioByID implements Comando {

    public Contexto execute(Object datos){

        Usuario user = FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByID((Long) datos);

        if(user == null){
            return new Contexto(ERROR_BUSCAR_USUARIO, user);
        }



        return new Contexto(BUSCAR_USUARIO_BY_ID, user);
    }

}
