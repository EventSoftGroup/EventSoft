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
        int ID_Usuario;
        Contexto contex = null;

        SAUsuario SAUsuario = FactoriaSA.getInstance().crearSAUsuarios();

        try{
            ID_Usuario = SAUsuario.crearUsuario((Usuario)datos);

            if(ID_Usuario == -1){
                contex = new Contexto(EventosNegocio.ERROR_CREAR_USUARIO, null);
            } else {
                contex = new Contexto(EventosNegocio.USUARIO_CREADO, ID_Usuario);
            }
        }
        catch(ExcepcionNegocio e) {
            contex = new Contexto(EventosNegocio.ERROR_CREAR_USUARIO, null);
        }

        return contex;
    }

}
