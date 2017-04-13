package es.fdi.eventsoft.negocio.modelo;

import es.fdi.eventsoft.negocio.modelo.enumerados.EstadosUsuario;

import java.util.List;

public class Organizador extends Profesional {
    private List<Evento> eventos;

    public Organizador() {
        super();
        this.eventos = null;
    }

    public Organizador(String empresa, String nif, List<Evento> eventos) {
        super(empresa, nif);
        this.eventos = eventos;
    }

    public Organizador(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, int codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String nif, List<Evento> eventos) {
        super(id, mail, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes, empresa, nif);
        this.eventos = eventos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "Organizador{" +
                "eventos=" + eventos +
                '}';
    }
}
