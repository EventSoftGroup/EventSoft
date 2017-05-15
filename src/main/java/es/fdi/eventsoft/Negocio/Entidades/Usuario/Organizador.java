package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Organizadores")
public class Organizador extends Profesional {

    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    @OneToMany(mappedBy = "organizador", fetch = FetchType.LAZY)
    private List<Evento> eventos;

    /****************************
     ******* CONSTRUCTORES ******
     ****************************/

    public Organizador() {}


    public Organizador(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public Organizador(String empresa, String CIF, List<Evento> eventos) {
        super(empresa, CIF);
        this.eventos = eventos;
    }

    public Organizador(String empresa, String cif, List<Valoracion> valoraciones_recibidas, List<Evento> eventos) {
        super(empresa, cif, valoraciones_recibidas);
        this.eventos = eventos;
    }

    public Organizador(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, String empresa, String cif, List<Valoracion> valoraciones_recibidas, List<Evento> eventos) {
        super(email, password, direccion, localidad, provincia, telefono, codigoPostal, estado, empresa, cif, valoraciones_recibidas);
        this.eventos = eventos;
    }

    public Organizador(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes_enviados, List<Mensaje> mensajes_recibidos, String empresa, String cif, List<Valoracion> valoraciones_recibidas, List<Evento> eventos) {
        super(email, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes_enviados, mensajes_recibidos, empresa, cif, valoraciones_recibidas);
        this.eventos = eventos;
    }

    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
