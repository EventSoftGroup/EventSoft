package es.fdi.eventsoft.negocio.Usuario;

import es.fdi.eventsoft.negocio.Mensaje;
import es.fdi.eventsoft.negocio.Servicio;
import es.fdi.eventsoft.negocio.enumerados.EstadosUsuario;

import java.util.List;

public class TProveedor extends TProfesional {
    private List<Servicio> servicios;

    public TProveedor() {
        super();
        this.servicios = null;
    }

    public TProveedor(String empresa, String nif, List<Servicio> servicios) {
        super(empresa, nif);
        this.servicios = servicios;
    }

    public TProveedor(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String nif, List<Servicio> servicios) {
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
        return super.toString() + System.getProperty("line.separator") + "    TProveedor{" +
                "servicios=" + servicios +
                '}';
    }
}
