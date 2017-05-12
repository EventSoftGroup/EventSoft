package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "PROFESIONAL")
public class Profesional extends Usuario implements Serializable {


    private String empresa;


    private String cif;



    @OneToMany(mappedBy = "profesional", fetch = FetchType.EAGER)
    private List<Valoracion> valoraciones_recibidas;




    public Profesional() {
        super();
        //this.valoraciones_recibidas = null;
        this.empresa = "";
        this.cif = "";
    }

    public Profesional(List<Valoracion> valoraciones_recibidas) {
        super();
        this.empresa = "";
        this.cif = "";
        this.valoraciones_recibidas = valoraciones_recibidas;
    }

    public Profesional(String empresa, String cif) {
        super();
        this.empresa = empresa;
        this.cif = cif;
    }

    public Profesional(String empresa, String cif, List<Valoracion> valoraciones_recibidas) {
        super();
        this.empresa = empresa;
        this.cif = cif;
        this.valoraciones_recibidas = valoraciones_recibidas;
    }

    public Profesional(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String cif, List<Valoracion> valoraciones_recibidas) {
        super(id, mail, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes);
        this.empresa = empresa;
        this.cif = cif;
        this.valoraciones_recibidas = valoraciones_recibidas;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public List<Valoracion> getValoraciones_recibidas() {
        return valoraciones_recibidas;
    }

    public void setValoraciones_recibidas(List<Valoracion> valoraciones_recibidas) {
        this.valoraciones_recibidas = valoraciones_recibidas;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesional{" +
                "empresa='" + empresa + '\'' +
                ", cif='" + cif + '\'' +
                ", valoraciones_recibidas=" + valoraciones_recibidas +
                '}';
    }
}
