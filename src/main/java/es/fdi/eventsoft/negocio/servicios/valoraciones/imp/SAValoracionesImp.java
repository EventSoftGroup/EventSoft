package es.fdi.eventsoft.negocio.servicios.valoraciones.imp;

import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.entidades.Valoracion;
import es.fdi.eventsoft.negocio.servicios.valoraciones.SAValoraciones;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 * */
public class SAValoracionesImp implements SAValoraciones {


    @Override
    public int crearValoracion(Valoracion valoracionNueva) {
        //TODO
        return 0;
    }

    @Override
    public Valoracion buscarValoracion(Valoracion valoracion) {
        //TODO
        return null;
    }

    @Override
    public int eliminarValoracion(Valoracion valoracion) {
        //TODO
        return 0;
    }

    @Override
    public List<Valoracion> buscarValoracionesByUsuario(Usuario usuario) {
        //TODO
        return null;
    }
}
