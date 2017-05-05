package es.fdi.eventsoft.negocio.__Usuario;

import es.fdi.eventsoft.negocio.Entidades.Evento;
import es.fdi.eventsoft.negocio.Entidades.Mensaje;
import es.fdi.eventsoft.negocio.__enumerados.EstadosUsuario;

import java.util.List;

public class TOrganizador extends TProfesional {
    private List<Evento> eventos;

    public TOrganizador() {
        super();
        this.eventos = null;
    }

    public TOrganizador(String empresa, String nif, List<Evento> eventos) {
        super(empresa, nif);
        this.eventos = eventos;
    }

    public TOrganizador(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String nif, List<Evento> eventos) {
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
        return super.toString() + System.getProperty("line.separator") + "    TOrganizador{" +
                "eventos=" + eventos +
                '}';
    }
}
