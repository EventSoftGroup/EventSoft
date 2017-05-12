package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.__enumerados.CategoriasEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;

    @ManyToOne
    private Organizador Organizador;

    private String lugar;

    private CategoriasEvento categoria;

    private Date fechaInicio;

    private Date fechaFin;


    @OneToMany(mappedBy = "evento")
    private List<EventoServicio> eventoServicios;



    //private List<String> participantes;

    @ManyToOne
    private Cliente cliente;
}
