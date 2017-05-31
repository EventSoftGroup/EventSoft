package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Usuarios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Tomas on 29/04/17.
 */
public class ComandoCrearUsuario implements Comando {

    public Contexto execute(Object datos){
        return new Contexto(FactoriaSA.getInstance().crearSAUsuarios().crearUsuario((Usuario)datos), null);
    }
}
