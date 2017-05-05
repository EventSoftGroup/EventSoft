package es.fdi.eventsoft.negocio.Comandos.Factoria_Comandos.Imp;

import es.fdi.eventsoft.negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.negocio.Comandos.Comandos_Usuario.Comando;
import es.fdi.eventsoft.negocio.Comandos.Comandos_Usuario.Imp.Comandos_Usuarios.ComandoCrearUsuario;
import es.fdi.eventsoft.presentacion.comandos.factoriaComandos.EventoGUI;

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
