package es.fdi.eventsoft.negocio;

import es.fdi.eventsoft.negocio.Usuario.TCliente;
import es.fdi.eventsoft.negocio.Usuario.TProfesional;

import java.util.Date;

public class Valoracion {
    private TCliente emisor;
    private TProfesional receptor;
    private Date fechaEnvio;
    private int valoracion;
    private String texto;
}
