package es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.Imp;

import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.Imp.SAEventosImp;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.SAEventos;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes.Imp.SAMensajesImp;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes.SAMensajes;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios.Imp.SAServiciosImp;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios.SAServicios;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.Imp.SAUsuarioImp;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Valoraciones.Imp.SAValoracionesImp;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Valoraciones.SAValoraciones;

/**
 * Created by Tomas on 29/04/17.
 */
public class FactoriaSAImp extends FactoriaSA {

    public SAUsuario crearSAUsuario(){
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
