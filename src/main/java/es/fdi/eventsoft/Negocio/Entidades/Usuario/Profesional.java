package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Profesionales")
public class Profesional extends Usuario implements Serializable {

    @NotBlank
    @Column(nullable = false)
    private String empresa;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String CIF;

    @OneToMany(mappedBy = "profesional", fetch = FetchType.LAZY)
    private List<Valoracion> valoraciones_recibidas;


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
