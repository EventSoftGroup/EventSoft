package es.fdi.eventsoft.negocio.Entidades;

import es.fdi.eventsoft.negocio.__Usuario.TCliente;
import es.fdi.eventsoft.negocio.__Usuario.TProfesional;

import java.util.Date;

public class Valoracion {
    private TCliente emisor;
    private TProfesional receptor;
    private Date fechaEnvio;
    private int valoracion;
    private String texto;
}
