package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes.Imp;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes.SAMensajes;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAMensajesImp implements SAMensajes {

    @Override
    public int crearMensaje(Mensaje mensajeNuevo) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public Mensaje buscarMensaje(Long id) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Mensaje.class);

        fachadaIntegracion.begin();
        Mensaje mensaje = (Mensaje) fachadaIntegracion.consulta(id);
        fachadaIntegracion.commit();

        return mensaje;
    }

    @Override
    public int eliminarMensaje(Mensaje mensaje) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public List<Mensaje> buscarMensajesByUser(Usuario usuario, boolean emisor) throws ExcepcionNegocio {
        //TODO
        return null;
    }
}
