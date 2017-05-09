package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.Imp;


import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.SAEventos;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAEventosImp implements SAEventos {


    @Override
    public int crearEvento(Evento eventoNuevo) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public Evento buscarEvento(Evento evento) throws ExcepcionNegocio {
        //TODO
        return null;
    }

    @Override
    public int eliminarEvento(Evento evento) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public int modificarEvento(Evento eventoModificado) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public List<Evento> buscarEventosByUsuario(Usuario usuario) throws ExcepcionNegocio {
        //TODO
        return null;
    }
}
