package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos;

import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAEventos {

    Long crearEvento(Evento eventoNuevo);

    EventosNegocio añadirServiciosAEvento(Long idEvento, List<Long> servicios);

    Evento buscarEvento(Long id);

    int eliminarEvento(Evento evento) throws ExcepcionNegocio;

    int modificarEvento(Evento eventoModificado) throws ExcepcionNegocio;

    List<Evento> buscarEventosByUsuario(Usuario usuario) throws ExcepcionNegocio;
    
}
