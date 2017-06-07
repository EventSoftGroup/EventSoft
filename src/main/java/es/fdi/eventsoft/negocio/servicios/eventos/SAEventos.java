package es.fdi.eventsoft.negocio.servicios.eventos;


import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAEventos {

    Long crearEvento(Evento eventoNuevo);

    EventosNegocio añadirServiciosAEvento(Long idEvento, List<Long> servicios);

    Evento buscarEvento(Long id);

    boolean eliminarEvento(Long Id);

    boolean modificarEvento(Evento eventoModificado);

    List<Evento> buscarEventosByUsuario(Usuario usuario);

    List<Evento> listarEventos();
    
}
