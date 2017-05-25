package es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion;

import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.Imp.FactoriaSAImp;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.SAEventos;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Mensajes.SAMensajes;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios.SAServicios;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Valoraciones.SAValoraciones;

/**
 * Created by Tomas on 29/04/17.
 */
public abstract class FactoriaSA {

    private static FactoriaSA uniqueInstance = new FactoriaSAImp();

    public static FactoriaSA getInstance() {
        return uniqueInstance;
    }

    //CREAR

    public abstract SAUsuario crearSAUsuarios();

    public abstract SAValoraciones crearSAValoraciones();

    public abstract SAMensajes crearSAMensajes();

    public abstract SAServicios crearSAServicios();

    public abstract SAEventos crearSAEventos();

}
