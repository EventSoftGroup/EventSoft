package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "PROFESIONAL")
public class Profesional extends Usuario implements Serializable {
    private String empresa;
    private String cif;
    @OneToMany(mappedBy = "mi_profesional")
    private List<Valoracion> valoraciones;

    public Profesional() {
        super();
        //this.valoraciones = null;
        this.empresa = "";
        this.cif = "";
    }

    public Profesional(List<Valoracion> valoraciones) {
        super();
        this.empresa = "";
        this.cif = "";
        this.valoraciones = valoraciones;
    }

    public Profesional(String empresa, String cif, List<Valoracion> valoraciones) {
        super();
        this.empresa = empresa;
        this.cif = cif;
        this.valoraciones = valoraciones;
    }

    public Profesional(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String cif, List<Valoracion> valoraciones) {
        super(id, mail, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes);
        this.empresa = empresa;
        this.cif = cif;
        this.valoraciones = valoraciones;
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

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "empresa='" + empresa + '\'' +
                ", cif='" + cif + '\'' +
                ", valoraciones=" + valoraciones +
                '}';
    }
}
