package es.fdi.eventsoft.negocio;

import es.fdi.eventsoft.negocio.Usuario.TCliente;
import es.fdi.eventsoft.negocio.Usuario.TOrganizador;
import es.fdi.eventsoft.negocio.enumerados.CategoriasEvento;

import java.util.Date;
import java.util.List;

public class Evento {
    private Long id;
    private String nombre;
    private TOrganizador TOrganizador;
    private String lugar;
    private CategoriasEvento categoria;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Servicio> servicios;
    private List<String> participantes;
    private List<TCliente> TClientes;
}
