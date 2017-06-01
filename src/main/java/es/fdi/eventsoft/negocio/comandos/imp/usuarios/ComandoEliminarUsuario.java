package es.fdi.eventsoft.negocio.comandos.imp.usuarios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoEliminarUsuario implements Comando {

    public Contexto execute(Object datos){
        //TODO
        return new Contexto(FactoriaSA.getInstance().crearSAUsuarios().eliminarUsuario((Usuario) datos), null);

    }

}
