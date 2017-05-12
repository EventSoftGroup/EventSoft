package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Profesional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "VALORACION")
public class Valoracion implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne
    private Profesional profesional;



    private Date fechaEnvio;
    private int valoracion;
    private String texto;

    public Valoracion() {}

    public Valoracion(Cliente cliente, Profesional profesional, int valoracion) {
        this.cliente = cliente;
        this.profesional = profesional;
        this.valoracion = valoracion;
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

    @Override
    public String toString() {
        return "Valoracion{" +
                ", ID=" + id +
                ", clienteID=" + cliente.getId() +
                ", profesionalID=" + profesional.getId() +

                ", valoracion=" + valoracion +

                '}';
    }
}
