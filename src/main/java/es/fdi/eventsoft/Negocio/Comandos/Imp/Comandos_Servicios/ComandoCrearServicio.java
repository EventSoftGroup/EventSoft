package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios;
import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoCrearServicio implements Comando {

    public Contexto execute(Object datos){
        Long id = FactoriaSA.getInstance().crearSAServicios().crearServicio((Servicio) datos);
        Contexto c;
        if(id == null){
            c = new Contexto(EventosNegocio.ERROR_CREAR_SERVICIO, null);
        }
        else {
            c = new Contexto(EventosNegocio.CREAR_SERVICIO, (Object)id);
        }
        return c;
    }

}
