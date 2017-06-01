package es.fdi.eventsoft.negocio.entidades;

import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Organizador;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Eventos")
@NamedQueries({
        @NamedQuery(name = "Evento.buscarEventosPorUsuario", query = "from Evento e join fetch e.cliente join fetch e.organizador where e.cliente = :cliente"),
        @NamedQuery(name = "Evento.buscarEventosPorUsuario_2", query = "from Evento e join fetch e.organizador join fetch e.cliente where e.organizador = :organizador")
})
public class Evento implements Serializable {

    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Organizador organizador;

    @Column(nullable = false)
    private CategoriasEvento categoria;

    @NotBlank
    @Column(nullable = false)
    private String lugar;

    @Column(name = "Fecha_Inicio", nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull
    private Date fechaInicio;


    @Column(name = "Fecha_Fin", nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull @Future
    private Date fechaFin;


    @OneToMany(mappedBy = "evento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<EventoServicio> eventoServicios;

    @Version long version;

    /****************************
     ******* CONSTRUCTORES ******
     ****************************/

    public enum CategoriasEvento {
        BODAS,
        DESPEDIDAS,
        BABY_SHOWER,
        COMIDA_EMPRESA
    }

    public Evento() {}

    public Evento(String nombre, String descripcion, Cliente cliente, Organizador organizador, CategoriasEvento categoria, String lugar, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.organizador = organizador;
        this.categoria = categoria;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Evento(String nombre, String descripcion, Cliente cliente, Organizador organizador, CategoriasEvento categoria, String lugar, Date fechaInicio, Date fechaFin, List<EventoServicio> eventoServicios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.organizador = organizador;
        this.categoria = categoria;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.eventoServicios = eventoServicios;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public CategoriasEvento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasEvento categoria) {
        this.categoria = categoria;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<EventoServicio> getEventoServicios() {
        return eventoServicios;
    }

    public void setEventoServicios(List<EventoServicio> eventoServicios) {
        this.eventoServicios = eventoServicios;
    }

    public void addEventoServicios(List<EventoServicio> eventoServicios) {
        for (EventoServicio ev :eventoServicios){
            if(!this.eventoServicios.contains(ev)) {
                this.eventoServicios.add(ev);
            }else{
                System.out.println("eventosServicios ya contiene el servicio");
            }
        }
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cliente=" + cliente +
                ", organizador=" + organizador +
                ", categoria=" + categoria +
                ", lugar='" + lugar + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
