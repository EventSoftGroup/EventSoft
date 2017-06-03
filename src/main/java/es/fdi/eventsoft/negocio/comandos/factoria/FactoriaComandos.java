package es.fdi.eventsoft.negocio.comandos.factoria;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.imp.FactoriaComandosImp;

/**
 * Created by Tomas on 29/04/17.
 */
public abstract class FactoriaComandos {

    private static FactoriaComandos uniqueInstance = new FactoriaComandosImp();

    public static FactoriaComandos getInstance(){
        return uniqueInstance;
    }

    public abstract Comando crearComando(EventosNegocio eventoNegocio);

}
