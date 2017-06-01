package es.fdi.eventsoft.negocio.servicios.valoraciones;

import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.entidades.Valoracion;
import es.fdi.eventsoft.negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAValoraciones {

    public int crearValoracion(Valoracion valoracionNueva) throws ExcepcionNegocio;

    public Valoracion buscarValoracion(Valoracion valoracion) throws ExcepcionNegocio;

    public int eliminarValoracion(Valoracion valoracion) throws ExcepcionNegocio;

    public List<Valoracion> buscarValoracionesByUsuario(Usuario usuario) throws ExcepcionNegocio;

}
