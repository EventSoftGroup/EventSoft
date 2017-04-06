package es.fdi.eventsoft.negocio.modelo;

import es.fdi.eventsoft.negocio.modelo.enumerados.EstadosMensaje;

import java.util.Date;

public class Mensaje {
    private Usuario emisor;
    private Usuario receptor;
    private Date fechaEnvio;
    private String asunto;
    private String mensaje;
    private EstadosMensaje estado;
}
