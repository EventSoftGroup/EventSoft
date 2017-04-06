package es.fdi.eventsoft.negocio.modelo;

import es.fdi.eventsoft.negocio.modelo.enumerados.CategoriasEvento;

import java.util.Date;
import java.util.List;

public class Evento {
    private Long id;
    private String nombre;
    private Organizador organizador;
    private String lugar;
    private CategoriasEvento categoria;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Servicio> servicios;
    private List<String> participantes;
    private List<Cliente> clientes;
}
