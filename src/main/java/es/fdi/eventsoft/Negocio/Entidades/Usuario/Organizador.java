package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;

import java.util.List;

public class Organizador extends Profesional {
    private List<Evento> eventos;

    public Organizador() {
        super(valoraciones);
        this.eventos = null;
    }

    public Organizador(String empresa, String nif, List<Evento> eventos) {
        super(empresa, nif, valoraciones);
        this.eventos = eventos;
    }

    public Organizador(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String nif, List<Evento> eventos) {
        super(id, mail, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes, empresa, nif, valoraciones);
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
        return super.toString() + System.getProperty("line.separator") + "    Organizador{" +
                "eventos=" + eventos +
                '}';
    }
}
