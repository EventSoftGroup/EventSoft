package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;

import java.util.Date;

public class Mensaje {

    private Usuario emisor;
    private Usuario receptor;
    private Date fechaEnvio;
    private String asunto;
    private String mensaje;
    private EstadosMensaje estado;


    public enum EstadosMensaje {
        LEIDO,
        NO_LEIDO
    }
}
