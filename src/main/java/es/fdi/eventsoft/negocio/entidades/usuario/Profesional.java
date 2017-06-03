package es.fdi.eventsoft.negocio.entidades.usuario;

import es.fdi.eventsoft.negocio.entidades.Mensaje;
import es.fdi.eventsoft.negocio.entidades.Valoracion;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Profesionales")
public class Profesional extends Usuario implements Serializable {

    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    @NotBlank
    @Column(nullable = false)
    protected String empresa;

    @NotBlank
    @Column(nullable = false, unique = true)
    protected String CIF;

    @OneToMany(mappedBy = "profesional", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Valoracion> valoraciones_recibidas;

    /****************************
     ******* CONSTRUCTORES ******
     ****************************/

    public Profesional() {}

    public Profesional(String empresa, String CIF) {
        this.empresa = empresa;
        this.CIF = CIF;
    }
    
    public Profesional(String empresa, String cif, List<Valoracion> valoraciones_recibidas) {
        this.empresa = empresa;
        this.CIF = cif;
        this.valoraciones_recibidas = valoraciones_recibidas;
    }

    public Profesional(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, String empresa, String cif, List<Valoracion> valoraciones_recibidas) {
        super(email, password, direccion, localidad, provincia, telefono, codigoPostal, estado);
        this.empresa = empresa;
        this.CIF = cif;
        this.valoraciones_recibidas = valoraciones_recibidas;
    }

    public Profesional(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes_enviados, List<Mensaje> mensajes_recibidos, String empresa, String cif, List<Valoracion> valoraciones_recibidas) {
        super(email, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes_enviados, mensajes_recibidos);
        this.empresa = empresa;
        this.CIF = cif;
        this.valoraciones_recibidas = valoraciones_recibidas;
    }

    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public List<Valoracion> getValoraciones_recibidas() {
        return valoraciones_recibidas;
    }

    public void setValoraciones_recibidas(List<Valoracion> valoraciones_recibidas) {
        this.valoraciones_recibidas = valoraciones_recibidas;
    }
}
