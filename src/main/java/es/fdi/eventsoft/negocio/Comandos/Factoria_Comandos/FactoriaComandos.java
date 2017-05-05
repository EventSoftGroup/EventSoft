package es.fdi.eventsoft.negocio.Comandos.Factoria_Comandos;

import es.fdi.eventsoft.negocio.Comandos.Comandos_Usuario.Comando;
import es.fdi.eventsoft.negocio.Comandos.Factoria_Comandos.Imp.FactoriaComandosImp;

/**
 * Created by Tomas on 29/04/17.
 */
public abstract class FactoriaComandos {

    private static FactoriaComandos uniqueInstance;

    public static FactoriaComandos getInstance(){
        if (uniqueInstance == null) {

            uniqueInstance = new FactoriaComandosImp();
        }

        return uniqueInstance;
    }

    public abstract Comando crearComando(int eventoNegocio);

}
