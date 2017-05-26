package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Proveedores")
public class Proveedor extends Profesional {

    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    @OneToMany(mappedBy = "proveedor")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Servicio> servicios = new ArrayList<>();

    /****************************
     ******* CONSTRUCTORES ******
     ****************************/

    public Proveedor() { }

    public Proveedor(Long id) {
        this.id = id;
    }

    public Proveedor(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Proveedor(String empresa, String CIF, List<Servicio> servicios) {
        super(empresa, CIF);
        this.servicios = servicios;
    }

    public Proveedor(String empresa, String cif, List<Valoracion> valoraciones_recibidas, List<Servicio> servicios) {
        super(empresa, cif, valoraciones_recibidas);
        this.servicios = servicios;
    }

    public Proveedor(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, String empresa, String cif, List<Valoracion> valoraciones_recibidas, List<Servicio> servicios) {
        super(email, password, direccion, localidad, provincia, telefono, codigoPostal, estado, empresa, cif, valoraciones_recibidas);
        this.servicios = servicios;
    }

    public Proveedor(String email, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes_enviados, List<Mensaje> mensajes_recibidos, String empresa, String cif, List<Valoracion> valoraciones_recibidas, List<Servicio> servicios) {
        super(email, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes_enviados, mensajes_recibidos, empresa, cif, valoraciones_recibidas);
        this.servicios = servicios;
    }

    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
