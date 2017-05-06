package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Profesional;

import java.util.Date;

public class Valoracion {
    private Cliente emisor;
    private Profesional receptor;
    private Date fechaEnvio;
    private int valoracion;
    private String texto;
}
