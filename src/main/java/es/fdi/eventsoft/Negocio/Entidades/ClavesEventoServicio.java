
package es.fdi.eventsoft.Negocio.Entidades;

import javax.persistence.*;
import java.io.Serializable;


@Embeddable
public class ClavesEventoServicio implements Serializable {

	/****************************
	 ********* ATRIBUTOS ********
	 ****************************/

	private static final long serialVersionUID = 0;

//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Id private Long id;

	private Long idEvento;

	private Long idServicio;

	/****************************
	 ******* CONSTRUCTORES ******
	 ****************************/

	public ClavesEventoServicio() {}


	public ClavesEventoServicio(Long idEvento, Long idServicio) {
		this.idEvento = idEvento;
		this.idServicio = idServicio;
	}

	/****************************
	 **** GETTERS AND SETTERS ***
	 ****************************/

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
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