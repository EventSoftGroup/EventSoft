package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Servicios")
public class Servicio implements Serializable{

    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private TiposServicio tipo = TiposServicio.OTROS;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String descripcion;

    @Column(name = "Fecha_Registro", nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotBlank @Past
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(nullable = false)
    private Proveedor proveedor;


    @OneToMany(mappedBy = "servicio", fetch = FetchType.LAZY)
    private List<EventoServicio> eventoServicios;


    @Version long version;

    public enum TiposServicio {OTROS }


    /****************************
     ******* CONTRUCTORES *******
     ****************************/


    public Servicio() { }

    public Servicio(TiposServicio tipo, String nombre, String descripcion, Date fechaRegistro, Proveedor proveedor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.proveedor = proveedor;
    }

    public Servicio(TiposServicio tipo, String nombre, String descripcion, Date fechaRegistro, Proveedor proveedor, List<EventoServicio> eventoServicios) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.proveedor = proveedor;
        this.eventoServicios = eventoServicios;
    }




    /***************************
     *** GETTERS AND SETTERS ***
     ***************************/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TiposServicio getTipo() {
        return tipo;
    }

    public void setTipo(TiposServicio tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<EventoServicio> getEventoServicios() {
        return eventoServicios;
    }

    public void setEventoServicios(List<EventoServicio> eventoServicios) {
        this.eventoServicios = eventoServicios;
    }
}
