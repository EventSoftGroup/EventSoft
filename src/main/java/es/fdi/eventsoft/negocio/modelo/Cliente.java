package es.fdi.eventsoft.negocio.modelo;

import java.util.List;

public class Cliente extends Usuario {
    private String nombre;
    private String apellidos;
    private List<Valoracion> valoraciones;
    private List<Evento> eventos;
}
