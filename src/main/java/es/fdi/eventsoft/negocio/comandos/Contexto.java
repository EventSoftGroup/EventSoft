package es.fdi.eventsoft.negocio.comandos;

/**
 * Created by Tomas on 29/04/17.
 */
public class Contexto {

    private EventosNegocio evento;

    private Object datos;

    public Contexto() {
        this.evento = null;
        this.datos = null;
    }

    public Contexto(EventosNegocio evento, Object datos) {
        this.evento = evento;
        this.datos = datos;
    }

    public EventosNegocio getEvento() {
        return evento;
    }

    public void setEvento(EventosNegocio evento) {
        this.evento = evento;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }
}
