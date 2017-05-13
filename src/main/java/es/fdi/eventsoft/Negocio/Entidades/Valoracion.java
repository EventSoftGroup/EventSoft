package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Profesional;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Valoraciones")
public class Valoracion implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(nullable = false)
    private Profesional profesional;

    @Column(name = "Fecha_Envio", nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotBlank @Past
    private Date fechaEnvio;

    @NotBlank @Digits(integer=1, fraction=0)
    @Size(min=0, max=5)
    @Column(nullable = false)
    private int valoracion;

    @NotBlank
    private String texto;

    @Version long version;

    public Valoracion() {}


    public Valoracion(Cliente cliente, Profesional profesional, Date fechaEnvio, int valoracion, String texto) {
        this.cliente = cliente;
        this.profesional = profesional;
        this.fechaEnvio = fechaEnvio;
        this.valoracion = valoracion;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
