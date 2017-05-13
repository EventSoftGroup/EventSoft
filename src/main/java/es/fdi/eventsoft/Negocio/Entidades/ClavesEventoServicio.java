
package es.fdi.eventsoft.Negocio.Entidades;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class ClavesEventoServicio implements Serializable {
	
	private static final long serialVersionUID = 0;



	private Integer idEvento;

	private Integer idServicio;

	public ClavesEventoServicio() {}


	public ClavesEventoServicio(Integer idEvento, Integer idServicio) {
		this.idEvento = idEvento;
		this.idServicio = idServicio;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

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