package es.fdi.eventsoft.negocio.comandos.imp.usuarios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

/**
 * Created by Tomas on 29/04/17.
 */
public class ComandoCrearUsuario implements Comando {

    public Contexto execute(Object datos){
        return new Contexto(FactoriaSA.getInstance().crearSAUsuarios().crearUsuario((Usuario)datos), null);
    }
}
