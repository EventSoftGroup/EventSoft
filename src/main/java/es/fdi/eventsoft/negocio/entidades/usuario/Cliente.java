package es.fdi.eventsoft.negocio.entidades.usuario;

import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.Mensaje;
import es.fdi.eventsoft.negocio.entidades.Valoracion;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Clientes")
public class Cliente extends Usuario implements Serializable {

    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String apellidos;


    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Valoracion> valoraciones_hechas;


    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Evento> eventos_Adscritos;

    /****************************
     ******* CONSTRUCTORES ******
     ****************************/

    public Cliente() {}


    public Cliente(String nombre, String apellidos, List<Valoracion> valoraciones_hechas, List<Evento> eventos_Adscritos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.valoraciones_hechas = valoraciones_hechas;
        this.eventos_Adscritos = eventos_Adscritos;
    }

    public Cliente(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, String nombre, String apellidos, List<Valoracion> valoraciones_hechas, List<Evento> eventos_Adscritos) {
        super(email, password, direccion, localidad, provincia, telefono, codigoPostal, estado);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.valoraciones_hechas = valoraciones_hechas;
        this.eventos_Adscritos = eventos_Adscritos;
    }

    public Cliente(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes_enviados, List<Mensaje> mensajes_recibidos, String nombre, String apellidos, List<Valoracion> valoraciones_hechas, List<Evento> eventos_Adscritos) {
        super(email, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes_enviados, mensajes_recibidos);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.valoraciones_hechas = valoraciones_hechas;
        this.eventos_Adscritos = eventos_Adscritos;
    }

    public Cliente(String email) {
        super.email = email;
    }

    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/

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

    public List<Evento> getEventos_Adscritos() {
        return eventos_Adscritos;
    }

    public void setEventos_Adscritos(List<Evento> eventos_Adscritos) {
        this.eventos_Adscritos = eventos_Adscritos;
    }

    public void mostrar(){
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellidos: " + this.getApellidos());
        System.out.println("Dir: " + this.getDireccion());
        System.out.println("Localizacion: " + this.getLocalidad());
        System.out.println("Provincia: " + this.getProvincia());
        System.out.println("CP: " + this.getCodigoPostal());
        System.out.println("Telefono: " + this.getTelefono());
    }
}
