package es.fdi.eventsoft.presentacion.comandos.Usuarios;

import es.fdi.eventsoft.negocio.excepcionNegocio.ExcepcionNegocio;
import es.fdi.eventsoft.negocio.Usuario.SAUsuario;
import es.fdi.eventsoft.negocio.Usuario.TUsuario;
import es.fdi.eventsoft.negocio.factoriaSA.FactoriaSA;
import es.fdi.eventsoft.presentacion.comandos.Comando;
import es.fdi.eventsoft.presentacion.controller.Contexto;
import es.fdi.eventsoft.presentacion.controller.EventoGUI;

/**
 * Created by Tomas on 29/04/17.
 */
public class ComandoCrearUsuario implements Comando {

    public Contexto execute(Object datos){
        int ID_Usuario;
        Contexto contex = null;

        SAUsuario SAUsuario = FactoriaSA.getInstance().crearSAUsuario();

        try{
            ID_Usuario = SAUsuario.crearUsuario((TUsuario)datos);

            if(ID_Usuario == -1){
                contex = new Contexto(EventoGUI.ERROR_CREAR_USUARIO, null);
            } else {
                contex = new Contexto(EventoGUI.USUARIO_CREADO, ID_Usuario);
            }
        }
        catch(ExcepcionNegocio e) {
            contex = new Contexto(EventoGUI.ERROR_CREAR_USUARIO, null);
        }

        return contex;
    }

}
