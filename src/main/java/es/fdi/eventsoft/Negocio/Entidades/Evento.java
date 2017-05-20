package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Eventos")
public class Evento implements Serializable {

    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

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
    @NotBlank
    private Date fechaInicio;


    @Column(name = "Fecha_Fin", nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotBlank @Future
    private Date fechaFin;


    @OneToMany(mappedBy = "evento", fetch = FetchType.LAZY)
    private List<EventoServicio> eventoServicios;

    @Version long version;

    /****************************
     ******* CONSTRUCTORES ******
     ****************************/

    public enum CategoriasEvento {
        bodas,
        despedidas
    }

    public Evento() {}

    public Evento(String nombre, Cliente cliente, Organizador organizador, CategoriasEvento categoria, String lugar, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.organizador = organizador;
        this.categoria = categoria;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Evento(String nombre, Cliente cliente, Organizador organizador, CategoriasEvento categoria, String lugar, Date fechaInicio, Date fechaFin, List<EventoServicio> eventoServicios) {
        this.nombre = nombre;
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
}
