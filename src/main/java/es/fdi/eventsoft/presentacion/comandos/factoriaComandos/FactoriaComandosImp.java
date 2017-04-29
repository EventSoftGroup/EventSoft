package es.fdi.eventsoft.presentacion.comandos.factoriaComandos;

import es.fdi.eventsoft.presentacion.comandos.Comando;
import es.fdi.eventsoft.presentacion.comandos.Usuarios.ComandoCrearUsuario;
import es.fdi.eventsoft.presentacion.controller.EventoGUI;
import es.fdi.eventsoft.presentacion.controller.Eventos;

/**
 * Created by Tomas on 29/04/17.
 */
public class FactoriaComandosImp extends FactoriaComandos {

    @Override
    public Comando crearComando(int evento) {
        Comando miComando = null;

        switch (evento) {

            //***************************************************//
            //**************** Comandos Usuarios ****************//
            //***************************************************//

            case EventoGUI.CREAR_USUARIO:
                miComando = new ComandoCrearUsuario();
                break;

        }

        return miComando;
    }

}
