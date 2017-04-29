package es.fdi.eventsoft.negocio;

import es.fdi.eventsoft.negocio.Usuario.TUsuario;
import es.fdi.eventsoft.negocio.enumerados.EstadosMensaje;

import java.util.Date;

public class Mensaje {
    private TUsuario emisor;
    private TUsuario receptor;
    private Date fechaEnvio;
    private String asunto;
    private String mensaje;
    private EstadosMensaje estado;
}
