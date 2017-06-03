package es.fdi.eventsoft.negocio.servicios.factoria.imp;

import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import es.fdi.eventsoft.negocio.servicios.eventos.imp.SAEventosImp;
import es.fdi.eventsoft.negocio.servicios.eventos.SAEventos;
import es.fdi.eventsoft.negocio.servicios.mensajes.imp.SAMensajesImp;
import es.fdi.eventsoft.negocio.servicios.mensajes.SAMensajes;
import es.fdi.eventsoft.negocio.servicios.servicios.imp.SAServiciosImp;
import es.fdi.eventsoft.negocio.servicios.servicios.SAServicios;
import es.fdi.eventsoft.negocio.servicios.usuarios.imp.SAUsuarioImp;
import es.fdi.eventsoft.negocio.servicios.usuarios.SAUsuario;
import es.fdi.eventsoft.negocio.servicios.valoraciones.imp.SAValoracionesImp;
import es.fdi.eventsoft.negocio.servicios.valoraciones.SAValoraciones;

/**
 * Created by Tomas on 29/04/17.
 */
public class FactoriaSAImp extends FactoriaSA {

    @Override
    public SAUsuario crearSAUsuarios(){
        return new SAUsuarioImp();
    }

    @Override
    public SAValoraciones crearSAValoraciones() {
        return new SAValoracionesImp();
    }

    @Override
    public SAMensajes crearSAMensajes() {
        return new SAMensajesImp();
    }

    @Override
    public SAServicios crearSAServicios() {
        return new SAServiciosImp();
    }

    @Override
    public SAEventos crearSAEventos() {
        return new SAEventosImp();
    }
}
