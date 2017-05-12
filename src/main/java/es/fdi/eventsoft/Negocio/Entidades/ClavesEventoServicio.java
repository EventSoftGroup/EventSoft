
package es.fdi.eventsoft.Negocio.Entidades;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class ClavesEventoServicio implements Serializable {
	
	private static final long serialVersionUID = 0;

	public ClavesEventoServicio() {}

	private Integer idEvento;

	private Integer idServicio;

	
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof ClavesEventoServicio))
			return false;
		ClavesEventoServicio pk = (ClavesEventoServicio) obj;
		if (!(idEvento == pk.idServicio))
			return false;
		if (!(idEvento == pk.idServicio))
			return false;
		return true;
	}

	public int hashCode() {
		int hashcode = 0;
		hashcode += idEvento;
		hashcode += idServicio;
		return hashcode;
	}
}