/**
 * 
 */
package es.fdi.eventsoft.Negocio.Entidades;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class EventoServicio implements Serializable {

	private static final long serialVersionUID = 0;
	
	@EmbeddedId private ClavesEventoServicio id;

	@ManyToOne
	@MapsId("idEvento")
	private Evento evento;
	
	@ManyToOne
	@MapsId("idServicio")
	private Servicio servicio;


	@Version long version;
	
	
	public EventoServicio() {}


	public EventoServicio(Evento evento, Servicio servicio) {
		this.servicio =servicio;
		this.evento = evento;
	}

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
}