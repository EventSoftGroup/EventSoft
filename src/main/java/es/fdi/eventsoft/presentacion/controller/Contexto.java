package es.fdi.eventsoft.presentacion.controller;

/**
 * Created by Tomas on 29/04/17.
 */
public class Contexto {

    private int evento;

    private Object datos;

    public Contexto() {
        this.evento = -1;
        this.datos = null;
    }

    public Contexto(int evento, Object datos) {
        this.evento = evento;
        this.datos = datos;
    }

    public int getEvento() {
        return evento;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }
}
