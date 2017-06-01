/**
 * 
 */
package es.fdi.eventsoft.negocio.entidades;

import javax.persistence.*;
import java.io.Serializable;


@Entity
//@IdClass(ClavesEventoServicio.class)
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames = {"evento_id", "servicio_id"})
})
public class EventoServicio implements Serializable {

	/****************************
	 ********* ATRIBUTOS ********
	 ****************************/

	private static final long serialVersionUID = 0;

	@EmbeddedId private ClavesEventoServicio id = new ClavesEventoServicio();

	@ManyToOne
	@MapsId("idEvento")
	private Evento evento;
	
	@ManyToOne
	@MapsId("idServicio")
	private Servicio servicio;


	@Version long version;

	/****************************
	 ******* CONSTRUCTORES ******
	 ****************************/
	
	public EventoServicio() {}


	public EventoServicio(Evento evento, Servicio servicio) {
		this.servicio = servicio;
		this.evento = evento;
	}

	/****************************
	 **** GETTERS AND SETTERS ***
	 ****************************/

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public ClavesEventoServicio getId() {
		return id;
	}

	public void setId(ClavesEventoServicio id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EventoServicio that = (EventoServicio) o;

		if (!evento.getId().equals(that.evento.getId())) return false;
		return servicio.getId().equals(that.servicio.getId());
	}

	@Override
	public int hashCode() {
		int result = evento.hashCode();
		result = 31 * result + servicio.hashCode();
		return result;
	}
}