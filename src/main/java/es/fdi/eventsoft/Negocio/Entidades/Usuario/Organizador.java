package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Organizador extends Profesional {

    @OneToMany(mappedBy = "Organizador")
    private List<Evento> eventos;

    public Organizador() {}

    public Organizador(List<Valoracion> valoraciones) {
        super(valoraciones);
        //this.eventos = null;
    }

    public Organizador(String empresa, String nif, List<Evento> eventos, List<Valoracion> valoraciones) {
        super(empresa, nif, valoraciones);
        //this.eventos = eventos;
    }

    public Organizador(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String nif, List<Evento> eventos, List<Valoracion> valoraciones) {
        super(id, mail, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes, empresa, nif, valoraciones);
        //this.eventos = eventos;
    }

    public Organizador(String empresa, String nif) {
        super(empresa, nif);
    }

//    public List<Evento> getEventos() {
//        return eventos;
//    }
//
//    public void setEventos(List<Evento> eventos) {
//        this.eventos = eventos;
//    }

    @Override
    public String toString() {
        return super.toString() + System.getProperty("line.separator") + "    Organizador{" +
                //"eventos=" + eventos +
                '}';
    }
}
