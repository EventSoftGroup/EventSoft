package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Profesional;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.__enumerados.TiposServicio;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Servicio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private TiposServicio tipo;

    private String nombre;

    private String descripcion;

    private Date fechaRegistro;

    @ManyToOne
    private Proveedor proveedor;


    @OneToMany(mappedBy = "servicio")
    private List<EventoServicio> eventoServicios;
}
