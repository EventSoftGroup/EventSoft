package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.ClavesValoracionCliProfesional;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Profesional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "VALORACION")
public class Valoracion implements Serializable {

    @EmbeddedId private ClavesValoracionCliProfesional id;

    @ManyToOne
    @MapsId("idCliente")
    private Cliente mi_cliente;
    @ManyToOne
    @MapsId("idProfesional")
    private Profesional mi_profesional;

    private Date fechaEnvio;
    private int valoracion;
    private String texto;

    public Valoracion() {}

    public Valoracion(ClavesValoracionCliProfesional id, Cliente mi_cliente, Profesional mi_profesional, Date fechaEnvio, int valoracion, String texto) {
        this.id = id;
        this.mi_cliente = mi_cliente;
        this.mi_profesional = mi_profesional;
        this.fechaEnvio = fechaEnvio;
        this.valoracion = valoracion;
        this.texto = texto;
    }

    public ClavesValoracionCliProfesional getId() {
        return id;
    }

    public void setId(ClavesValoracionCliProfesional id) {
        this.id = id;
    }

    public Cliente getMi_cliente() {
        return mi_cliente;
    }

    public void setMi_cliente(Cliente mi_cliente) {
        this.mi_cliente = mi_cliente;
    }

    public Profesional getMi_profesional() {
        return mi_profesional;
    }

    public void setMi_profesional(Profesional mi_profesional) {
        this.mi_profesional = mi_profesional;
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

    @Override
    public String toString() {
        return "Valoracion{" +
                "id=" + id +
                ", mi_cliente=" + mi_cliente +
                ", mi_profesional=" + mi_profesional +
                ", fechaEnvio=" + fechaEnvio +
                ", valoracion=" + valoracion +
                ", texto='" + texto + '\'' +
                '}';
    }
}
