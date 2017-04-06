package es.fdi.eventsoft.negocio.modelo;

import es.fdi.eventsoft.negocio.modelo.enumerados.EstadosUsuario;

import java.util.List;

public class Usuario {
    private Long id;
    private String mail;
    private String hash;
    private String salt;
    private String direccion;
    private String localidad;
    private String provincia;
    private int codigoPostal;
    private EstadosUsuario estado;
    private List<Mensaje> mensajes;
}
