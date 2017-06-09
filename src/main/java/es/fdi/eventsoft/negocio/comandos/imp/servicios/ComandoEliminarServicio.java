package es.fdi.eventsoft.negocio.comandos.imp.servicios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import java.util.List;

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
            contex.setDatos(new String("Servicio Eliminado Correctamente"));
        }
        else if(respuesta == 1){
            contex.setEvento(EventosNegocio.ERROR_ELIMINAR_SERVICIO);
            contex.setDatos(new String("¡ERROR! No se pudo eliminar el servicio"));
        }
        else if(respuesta == 2){
            contex.setEvento(EventosNegocio.ERROR_SERVICIO_ASOCIADO_A_EVENTO);
            contex.setDatos(new String("¡ERROR! El servicio está asociado a algún evento en desarrollo o futuro"));
        }

        return contex;
    }

}
