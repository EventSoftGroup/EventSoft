package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Validadores.Telefono;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Usuarios")
public class Usuario implements Serializable {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    @Id private Long id;


    @NotBlank @Column(nullable = false, unique = true)
    @Email private String email;

    @NotBlank @Size(min=4, max=16)
    @Column(nullable = false)
    private String password;

    @NotBlank
    private String direccion;

    @NotBlank
    private String localidad;

    @NotBlank
    private String provincia;

    @Telefono
    @Column(nullable = false)
    private String telefono;

    @NotBlank @Digits(integer=5, fraction=0)
    //@Pattern(regexp = "\\d{5}")
    @Pattern(regexp = "0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}")
    @Column(nullable = false, unique = true)
    private String codigoPostal;

    @Column(nullable = false)
    private EstadosUsuario estado;

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.ALL)
    private List<Mensaje> mensajes_enviados;


    @OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL)
    private List<Mensaje> mensajes_recibidos;

    @Version private long version;


    public enum EstadosUsuario { ACTIVO, PENDIENTE, BANEADO }


    public Usuario() { }

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
