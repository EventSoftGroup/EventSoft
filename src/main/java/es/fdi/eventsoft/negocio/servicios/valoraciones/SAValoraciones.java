package es.fdi.eventsoft.negocio.servicios.valoraciones;

import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.entidades.Valoracion;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAValoraciones {

    public int crearValoracion(Valoracion valoracionNueva);

    public Valoracion buscarValoracion(Valoracion valoracion);

    public int eliminarValoracion(Valoracion valoracion);

    public List<Valoracion> buscarValoracionesByUsuario(Usuario usuario);

}
