package es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.Imp;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Usuarios.ComandoCrearUsuario;

/**
 * Created by Tomas on 29/04/17.
 */
public class FactoriaComandosImp extends FactoriaComandos {

    public Comando crearComando(EventosNegocio tipoComando) {
        Comando miComando = null;

        switch (tipoComando) {

            //***************************************************//
            //**************** Comandos Usuarios ****************//
            //***************************************************//

            case CREAR_USUARIO:
                miComando = new ComandoCrearUsuario();
                break;

        }

        return miComando;
    }

}
