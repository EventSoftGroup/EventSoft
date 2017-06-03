package es.fdi.eventsoft.negocio.servicios.mensajes.imp;


import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.entidades.Mensaje;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import es.fdi.eventsoft.negocio.servicios.mensajes.SAMensajes;
import es.fdi.eventsoft.negocio.servicios.usuarios.SAUsuario;
import javafx.util.Pair;

import java.util.Arrays;
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
    public Mensaje buscarMensaje(Long id) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Mensaje.class);

        fachadaIntegracion.begin();
        Mensaje mensaje = (Mensaje) fachadaIntegracion.consulta(id);
        fachadaIntegracion.commit();

        return mensaje;
    }

    @Override
    public boolean eliminarMensaje(Long id) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Mensaje.class);

        boolean respuesta;

        fachadaIntegracion.begin();
        respuesta = fachadaIntegracion.baja(id);
        fachadaIntegracion.commit();

        return respuesta;
    }

    @Override
    public List<Mensaje> buscarMensajesByUser(Usuario usuario, boolean emisor) {
        FachadaIntegracion integra;
        List<Mensaje> lista = null;


        if(FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByID(usuario.getId()) != null){

            integra = FachadaIntegracion.newInstance(Mensaje.class);

            integra.begin();

            if(emisor) lista = integra.ejecutarNamedQuery("Mensaje.LISTADO_MENSAJES_BY_EMISOR", Arrays.asList(new Pair<>("emisor", usuario)));
            else lista = integra.ejecutarNamedQuery("Mensaje.LISTADO_MENSAJES_BY_RECEPTOR", Arrays.asList(new Pair<>("receptor", usuario)));

            integra.commit();
        }


        return lista;
    }

    @Override
    public Long totalMensajes() {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(Mensaje.class);

        integra.begin();
        Long num = integra.getRowCount();
        integra.commit();

        return num;
    }
}
