package es.fdi.eventsoft.negocio.Usuario;

import es.fdi.eventsoft.negocio.Mensaje;
import es.fdi.eventsoft.negocio.enumerados.EstadosUsuario;

import java.util.List;

public class TProfesional extends TUsuario {
    private String empresa;
    private String cif;

    public TProfesional() {
        super();
        this.empresa = "";
        this.cif = "";
    }

    public TProfesional(String empresa, String cif) {
        this.empresa = empresa;
        this.cif = cif;
    }

    public TProfesional(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String cif) {
        super(id, mail, password, direccion, localidad, provincia, telefono, codigoPostal, estado, mensajes);
        this.empresa = empresa;
        this.cif = cif;
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

    @Override
    public String toString() {
        return super.toString() + System.getProperty("line.separator") + "    TProfesional{" +
                "empresa='" + empresa + '\'' +
                ", cif='" + cif + '\'' +
                '}';
    }
}
