package es.fdi.eventsoft.presentacion.comandos.factoriaComandos;

import es.fdi.eventsoft.presentacion.comandos.Comando;

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
