package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario.EstadosUsuario.ACTIVO;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID ")
    private Long id;
    private String mail;
    private String password;
    private String direccion;
    private String localidad;
    private String provincia;
    private String telefono;
    private String codigoPostal;
    private EstadosUsuario estado;

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.ALL)
    private List<Mensaje> mensajes;



    public enum EstadosUsuario {
        ACTIVO,
        PENDIENTE,
        BANEADO
    }


    public Usuario() {
        this.id = null;
        this.mail = "";
        this.password = "";
        this.direccion = "";
        this.localidad = "";
        this.provincia = "";
        this.telefono = "";
        this.codigoPostal = "";
        this.estado = ACTIVO;
        this.mensajes = null;
    }

    public Usuario(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.mensajes = mensajes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", estado=" + estado +
                //", mensajes=" + mensajes +
                '}';
    }
}
