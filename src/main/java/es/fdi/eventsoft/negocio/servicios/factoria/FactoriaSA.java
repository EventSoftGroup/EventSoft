package es.fdi.eventsoft.negocio.servicios.factoria;

import es.fdi.eventsoft.negocio.servicios.factoria.imp.FactoriaSAImp;
import es.fdi.eventsoft.negocio.servicios.eventos.SAEventos;
import es.fdi.eventsoft.negocio.servicios.mensajes.SAMensajes;
import es.fdi.eventsoft.negocio.servicios.servicios.SAServicios;
import es.fdi.eventsoft.negocio.servicios.usuarios.SAUsuario;
import es.fdi.eventsoft.negocio.servicios.valoraciones.SAValoraciones;

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
