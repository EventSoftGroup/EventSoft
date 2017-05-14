package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Usuarios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

/**
 * Created by Tomas on 29/04/17.
 */
public class ComandoCrearUsuario implements Comando {

    public Contexto execute(Object datos){

            if(FactoriaSA.getInstance().crearSAUsuarios().crearUsuario((Usuario)datos)){
                return new Contexto(EventosNegocio.USUARIO_CREADO, null);
            }else{
                return new Contexto(EventosNegocio.ERROR_CREAR_USUARIO, null);
            }
    }
}
