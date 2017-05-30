package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoEliminarServicio implements Comando {

    public Contexto execute(Object datos){
        //TODO
        Contexto contex = new Contexto();

        boolean respuesta = FactoriaSA.getInstance().crearSAServicios().eliminarServicio((Long) datos);
        if(respuesta == true){
            contex.setEvento(EventosNegocio.ELIMINAR_SERVICIO);
        }
        else{
            contex.setEvento(EventosNegocio.ERROR_ELIMINAR_SERVICIO);
        }

        return contex;
    }

}
