package es.fdi.eventsoft.negocio.Usuario;

import es.fdi.eventsoft.negocio.excepcionNegocio.ExcepcionNegocio;

/**
 * Created by Tomas on 29/04/17.
 */
public interface SAUsuario {

    public int crearUsuario(TUsuario usuarioNuevo) throws ExcepcionNegocio;

}
