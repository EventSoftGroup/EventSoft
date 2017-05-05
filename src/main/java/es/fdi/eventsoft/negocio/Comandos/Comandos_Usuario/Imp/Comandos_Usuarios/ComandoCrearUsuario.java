package es.fdi.eventsoft.negocio.Comandos.Comandos_Usuario.Imp.Comandos_Usuarios;

import es.fdi.eventsoft.negocio.__excepcionNegocio.ExcepcionNegocio;
import es.fdi.eventsoft.negocio.ServiciosAplicacion.ServicioAplicacion_Usuario.SAUsuario;
import es.fdi.eventsoft.negocio.__Usuario.TUsuario;
import es.fdi.eventsoft.negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.negocio.Comandos.Comandos_Usuario.Comando;
import es.fdi.eventsoft.presentacion.controller.Contexto;
import es.fdi.eventsoft.presentacion.comandos.factoriaComandos.EventoGUI;

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
