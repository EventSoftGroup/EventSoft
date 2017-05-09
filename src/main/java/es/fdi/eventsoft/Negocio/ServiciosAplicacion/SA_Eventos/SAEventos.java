package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos;

import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAEventos {

    public int crearEvento(Evento eventoNuevo) throws ExcepcionNegocio;

    public Evento buscarEvento(Evento evento) throws ExcepcionNegocio;

    public int eliminarEvento(Evento evento) throws ExcepcionNegocio;

    public int modificarEvento(Evento eventoModificado) throws ExcepcionNegocio;

    public List<Evento> buscarEventosByUsuario(Usuario usuario) throws ExcepcionNegocio;
    
}
