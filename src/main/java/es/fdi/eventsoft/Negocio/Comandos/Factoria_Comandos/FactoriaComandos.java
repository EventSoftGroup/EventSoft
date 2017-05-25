package es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.Imp.FactoriaComandosImp;

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
