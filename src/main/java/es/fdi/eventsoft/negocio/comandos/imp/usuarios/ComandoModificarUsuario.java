package es.fdi.eventsoft.negocio.comandos.imp.usuarios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoModificarUsuario implements Comando {

    public Contexto execute(Object datos){
        FactoriaSA.getInstance().crearSAUsuarios().modificarUsuario((Usuario) datos);

        return new Contexto(EventosNegocio.MODIFICAR_USUARIO, true);
    }

}