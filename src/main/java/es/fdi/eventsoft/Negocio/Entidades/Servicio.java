package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "Servicios", uniqueConstraints={
        @UniqueConstraint(columnNames = {"tipo", "nombre", "proveedor_id"})
})
@NamedQueries({
        @NamedQuery(name = "Servicio.buscarPorEvento", query = "from Servicio where :evento member of eventoServicios"),
        @NamedQuery(name = "Servicio.buscarEntreFechas", query = "from Servicio"),
        @NamedQuery(name = "Servicio.buscarPorTipoServicio", query = "from Servicio s where s.tipo = :tipoServicio")
})
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
    @NotNull @Past
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(nullable = false)
    private Proveedor proveedor = new Proveedor();


    @OneToMany(mappedBy = "servicio", fetch = FetchType.LAZY)
    private List<EventoServicio> eventoServicios = new ArrayList<>();


    @Version long version;

    public enum TiposServicio {BODAS, JARDINES, CATERING, DJ, FLORISTA, OTROS}


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

    public Servicio(TiposServicio tipo, String nombre, String descripcion, Proveedor proveedor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getFechaRegistroString(){
        return new SimpleDateFormat("dd-MM-yyyy").format(this.fechaRegistro);
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

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", proveedor=" + proveedor +
                '}';
    }
}
