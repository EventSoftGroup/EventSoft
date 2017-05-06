package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.__enumerados.CategoriasEvento;

import java.util.Date;
import java.util.List;

public class Evento {
    private Long id;
    private String nombre;
    private Organizador Organizador;
    private String lugar;
    private CategoriasEvento categoria;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Servicio> servicios;
    private List<String> participantes;
    private List<Cliente> Clientes;
}
