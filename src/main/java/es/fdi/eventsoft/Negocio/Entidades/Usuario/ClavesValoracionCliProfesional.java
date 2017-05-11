package es.fdi.eventsoft.Negocio.Entidades.Usuario;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Tomas on 11/05/2017.
 */
@Embeddable
public class ClavesValoracionCliProfesional implements Serializable {

    private Integer idCliente;

    private Integer idProfesional;

    public ClavesValoracionCliProfesional() {}

    public ClavesValoracionCliProfesional(Integer idCliente, Integer idProfesional) {
        this.idCliente = idCliente;
        this.idProfesional = idProfesional;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof ClavesValoracionCliProfesional))
            return false;
        ClavesValoracionCliProfesional pk = (ClavesValoracionCliProfesional) obj;
        if (!(idCliente == pk.idCliente))
            return false;
        if (!(idProfesional == pk.idProfesional))
            return false;
        return true;
    }

    public int hashCode() {
        int hashcode = 0;
        hashcode += idCliente;
        hashcode += idProfesional;
        return hashcode;
    }
}
