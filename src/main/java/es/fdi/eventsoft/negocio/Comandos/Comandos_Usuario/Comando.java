package es.fdi.eventsoft.negocio.Comandos.Comandos_Usuario;

import es.fdi.eventsoft.presentacion.controller.Contexto;

/**
 * Created by Tomas on 29/04/17.
 */
public abstract interface Comando {

    public abstract Contexto execute(Object datos);
}
