package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoEliminarServicio implements Comando {

    public Contexto execute(Object datos){
        //TODO
        Contexto contex = new Contexto();

        int respuesta = FactoriaSA.getInstance().crearSAServicios().eliminarServicio((Long) datos);
        if(respuesta == 0){
            contex.setEvento(EventosNegocio.ELIMINAR_SERVICIO);
            contex.setDatos(new String("Servicio Eliminado Correctamente."));
        }
        else if(respuesta == 1){
            contex.setEvento(EventosNegocio.ERROR_ELIMINAR_SERVICIO);
            contex.setDatos(new String("ERROR al eliminar el servicio."));
        }
        else if(respuesta == 2){
            contex.setEvento(EventosNegocio.ERROR_SERVICIO_ASOCIADO_A_EVENTO);
            contex.setDatos(new String("ERROR. El servicio está asociado a algún evento."));
        }

        return contex;
    }

}
