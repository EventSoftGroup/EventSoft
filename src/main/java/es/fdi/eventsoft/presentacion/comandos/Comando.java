package es.fdi.eventsoft.presentacion.comandos;

import es.fdi.eventsoft.presentacion.controller.Contexto;

/**
 * Created by Tomas on 29/04/17.
 */
public abstract interface Comando {

    public abstract Contexto execute(Object datos);
}
