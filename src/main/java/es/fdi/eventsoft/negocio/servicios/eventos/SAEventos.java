package es.fdi.eventsoft.negocio.servicios.eventos;


import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAEventos {

    /** Crea un evento y retorna el resultado
     *
     * @param eventoNuevo evento para crear en BBDD
     * @return  if (id >0) CREAR_EVENTO;
                else if(id == -1L) ERROR_CREAR_EVENTO;
                else if(id == -2L) ERROR_CLIENTE_ERRONEO;
                else if(id == -3L) ERROR_ORGANIZADOR_ERRONEO;
     */
    Long crearEvento(Evento eventoNuevo);

    EventosNegocio añadirServiciosAEvento(Long idEvento, List<Long> servicios);

    Evento buscarEvento(Long id);

    Evento buscarEventoParaModificar(Long id);

    boolean eliminarEvento(Long Id);

    boolean modificarEvento(Evento eventoModificado);

    List<Evento> buscarEventosByUsuario(Usuario usuario);

    List<Evento> listarEventos();
    
}
