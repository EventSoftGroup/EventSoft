package es.fdi.eventsoft.negocio.comandos.imp.servicios;
import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

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
