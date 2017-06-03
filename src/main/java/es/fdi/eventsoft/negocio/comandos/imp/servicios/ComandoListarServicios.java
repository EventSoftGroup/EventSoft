package es.fdi.eventsoft.negocio.comandos.imp.servicios;


import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoListarServicios implements Comando {

    public Contexto execute(Object datos){
        return new Contexto(EventosNegocio.LISTAR_SERVICIOS, FactoriaSA.getInstance().crearSAServicios().listarServicios());
    }

}
