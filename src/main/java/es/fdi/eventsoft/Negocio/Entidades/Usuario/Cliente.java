package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Usuario implements Serializable {


    private String nombre;

    private String apellidos;


    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Valoracion> valoraciones_hechas;


    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Evento> eventos_Adscritos;

    public Cliente() {}

    public Cliente(String nombre, String apellido) {
        super();
        this.nombre = nombre;
        this.apellidos = apellido;
        this.valoraciones_hechas = null;
    }

    public Cliente(String nombre, String apellidos, List<Valoracion> valoraciones_hechas/*, List<Evento> eventos*/) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.valoraciones_hechas = valoraciones_hechas;
        //this.eventos = eventos;
    }

    public Cliente(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String nombre, String apellidos, List<Valoracion> valoraciones_hechas/*, List<Evento> eventos*/) {
        super(id, mail, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.valoraciones_hechas = valoraciones_hechas;
        //this.eventos = eventos;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Valoracion> getValoraciones_hechas() {
        return valoraciones_hechas;
    }

    public void setValoraciones_hechas(List<Valoracion> valoraciones_hechas) {
        this.valoraciones_hechas = valoraciones_hechas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", valoraciones_hechas=" + valoraciones_hechas +
                "} " + super.toString();
    }
}
