package es.fdi.eventsoft.negocio.ServiciosAplicacion.ServicioAplicacion_Usuario;

import es.fdi.eventsoft.negocio.__Usuario.TUsuario;
import es.fdi.eventsoft.negocio.__excepcionNegocio.ExcepcionNegocio;

/**
 * Created by Tomas on 29/04/17.
 */
public interface SAUsuario {

    public int crearUsuario(TUsuario usuarioNuevo) throws ExcepcionNegocio;

}
