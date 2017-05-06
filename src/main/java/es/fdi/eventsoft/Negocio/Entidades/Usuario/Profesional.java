package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import es.fdi.eventsoft.Negocio.Entidades.Mensaje;

import java.util.List;

public class Profesional extends Usuario {
    private String empresa;
    private String cif;

    public Profesional() {
        super();
        this.empresa = "";
        this.cif = "";
    }

    public Profesional(String empresa, String cif) {
        this.empresa = empresa;
        this.cif = cif;
    }

    public Profesional(Long id, String mail, String password, String direccion, String localidad, String provincia, String telefono, String codigoPostal, EstadosUsuario estado, List<Mensaje> mensajes, String empresa, String cif) {
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
        return super.toString() + System.getProperty("line.separator") + "    Profesional{" +
                "empresa='" + empresa + '\'' +
                ", cif='" + cif + '\'' +
                '}';
    }
}
