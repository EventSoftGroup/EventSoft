package es.fdi.eventsoft.Negocio.Comandos;

/**
 * Created by Tomas on 29/04/17.
 */
public abstract interface Comando {

    public abstract Contexto execute(Object datos);
}
