package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MENSAJES")
public class Mensaje {

    @Id
    @Column(name = "MENSAJE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMISOR_ID")
    private Usuario emisor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECEPTOR_ID")
    private Usuario receptor;
    private Date fechaEnvio;
    private String asunto;
    private String mensaje;
    private EstadosMensaje estado;


    public enum EstadosMensaje {
        LEIDO,
        NO_LEIDO
    }

    public Mensaje() {
        this.id = null;
        this.emisor = null;
        this.receptor = null;
        this.fechaEnvio = null;
        this.asunto = "";
        this.mensaje = "";
        this.estado = EstadosMensaje.NO_LEIDO;
    }

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

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", emisor=" + emisor +
                ", receptor=" + receptor +
                ", fechaEnvio=" + fechaEnvio +
                ", asunto='" + asunto + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", estado=" + estado +
                '}';
    }
}
