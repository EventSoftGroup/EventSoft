package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;

import java.util.List;

public class Proveedor extends Profesional {
    private List<Servicio> servicios;

    public Proveedor() {
        super();
        this.servicios = null;
    }

    public Proveedor(String empresa, String nif, List<Servicio> servicios) {
        super(empresa, nif);
        this.servicios = servicios;
    }

    public Proveedor(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String nif, List<Servicio> servicios) {
        super(id, mail, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes, empresa, nif);
        this.servicios = servicios;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return super.toString() + System.getProperty("line.separator") + "    Proveedor{" +
                "__servicios=" + servicios +
                '}';
    }
}
