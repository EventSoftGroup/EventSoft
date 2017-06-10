package es.fdi.eventsoft.negocio.entidades.usuario;

import es.fdi.eventsoft.negocio.entidades.Mensaje;
import es.fdi.eventsoft.negocio.entidades.validadores.Telefono;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Usuarios")
@NamedQueries({
        @NamedQuery(name = "Usuario.buscarPorEmail", query = "from Usuario u where u.email = :email")
})
public class Usuario implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    @Id protected Long id;

    private String roles;


    @NotBlank @Column(nullable = false, unique = true)
    @Email protected String email;

    @Column(nullable = false)
    protected String password;

    @NotBlank
    protected String direccion;

    @NotBlank
    protected String localidad;

    @NotBlank
    protected String provincia;

    @Telefono
    @Column(nullable = false)
    protected String telefono;

    //@NotBlank //@Digits(integer=5, fraction=0)
    //@Pattern(regexp = "\\d{5}")
    @Pattern(regexp = "0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}", message = "Formato incorrecto")
    @Column(nullable = false)
    protected String codigoPostal;

    @Column(nullable = false)
    protected EstadosUsuario estado;

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    protected List<Mensaje> mensajes_enviados = new ArrayList<Mensaje>();


    @OneToMany(mappedBy = "receptor", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    protected List<Mensaje> mensajes_recibidos = new ArrayList<Mensaje>();

    @Version protected long version;

    public Usuario(long l) {
        this.id = l;
    }


    public enum EstadosUsuario { ACTIVO, PENDIENTE, BANEADO }

    /****************************
     ******* CONSTRUCTORES ******
     ****************************/


    public Usuario() { }

    public Usuario(Long id) { this.id = id; }

    public Usuario(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado) {
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
    }

    public Usuario(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes_enviados, List<Mensaje> mensajes_recibidos) {
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.mensajes_enviados = mensajes_enviados;
        this.mensajes_recibidos = mensajes_recibidos;
    }

    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public EstadosUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadosUsuario estado) {
        this.estado = estado;
    }

    public List<Mensaje> getMensajes_enviados() {
        return mensajes_enviados;
    }

    public void setMensajes_enviados(List<Mensaje> mensajes_enviados) {
        this.mensajes_enviados = mensajes_enviados;
    }

    public List<Mensaje> getMensajes_recibidos() {
        return mensajes_recibidos;
    }

    public void setMensajes_recibidos(List<Mensaje> mensajes_recibidos) {
        this.mensajes_recibidos = mensajes_recibidos;
    }
    public void mostrar(){
        System.out.println("Email: " + this.getEmail());
        System.out.println("Dir: " + this.getDireccion());
        System.out.println("Localidad: " + this.getLocalidad());
        System.out.println("Provincia: " + this.getProvincia());
        System.out.println("CP: " + this.getCodigoPostal());
        System.out.println("Telef: " + this.getTelefono());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", roles='" + roles + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", estado=" + estado +
                ", mensajes_enviados=" + mensajes_enviados +
                ", mensajes_recibidos=" + mensajes_recibidos +
                ", version=" + version +
                '}';
    }
}
