package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes.Imp;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes.SAMensajes;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.Date;
import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAMensajesImp implements SAMensajes {

    @Override
    public Long crearMensaje(Mensaje mensajeNuevo) {

        FachadaIntegracion integra;
        SAUsuario saUser = FactoriaSA.getInstance().crearSAUsuarios();
        Usuario emisor;
        Usuario receptor;
        Long idMensaje = -1L;



        emisor= saUser.buscarUsuarioByID(mensajeNuevo.getEmisor().getId());

        if(emisor != null){
            receptor = saUser.buscarUsuarioByEmail(mensajeNuevo.getReceptor().getEmail());

            if(receptor != null){

                mensajeNuevo.setEmisor(emisor);
                mensajeNuevo.setReceptor(receptor);
                mensajeNuevo.setAsunto(mensajeNuevo.getAsunto().trim());
                mensajeNuevo.setEstado(Mensaje.EstadosMensaje.NO_LEIDO);
                mensajeNuevo.setFechaEnvio(new Date());

                integra = FachadaIntegracion.newInstance(Mensaje.class);

                integra.begin();
                idMensaje = ((Mensaje) integra.alta(mensajeNuevo)).getId();
                integra.commit();
            }
        }

        return (idMensaje >0)? idMensaje : -1L;
    }

    @Override
    public Mensaje buscarMensaje(Mensaje mensaje) throws ExcepcionNegocio {
        //TODO
        return null;
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
