package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "Mensajes")
public class Mensaje {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Emisor", nullable = false)
    @NotNull
    private Usuario emisor;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Receptor", nullable = false)
    @NotNull
    private Usuario receptor;


    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotBlank @Past
    @Column(nullable = false)
    private Date fechaEnvio;

    @NotBlank
    @Column(nullable = false)
    private String asunto;

    @NotBlank
    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private EstadosMensaje estado;

    @Version long version;


    public enum EstadosMensaje { LEIDO, NO_LEIDO }




    public Mensaje() {}

    public Mensaje(Long id, Usuario emisor, Usuario receptor, Date fechaEnvio, String asunto, String mensaje, EstadosMensaje estado) {
        this.id = id;
        this.emisor = emisor;
        this.receptor = receptor;
        this.fechaEnvio = fechaEnvio;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public EstadosMensaje getEstado() {
        return estado;
    }

    public void setEstado(EstadosMensaje estado) {
        this.estado = estado;
    }
}
