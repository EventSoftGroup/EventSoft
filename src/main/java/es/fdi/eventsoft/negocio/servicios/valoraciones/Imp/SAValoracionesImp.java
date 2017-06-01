package es.fdi.eventsoft.negocio.servicios.valoraciones.Imp;

import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.entidades.Valoracion;
import es.fdi.eventsoft.negocio.servicios.valoraciones.SAValoraciones;
import es.fdi.eventsoft.negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 * */
public class SAValoracionesImp implements SAValoraciones {


    @Override
    public int crearValoracion(Valoracion valoracionNueva) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public Valoracion buscarValoracion(Valoracion valoracion) throws ExcepcionNegocio {
        //TODO
        return null;
    }

    @Override
    public int eliminarValoracion(Valoracion valoracion) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public List<Valoracion> buscarValoracionesByUsuario(Usuario usuario) throws ExcepcionNegocio {
        //TODO
        return null;
    }
}
