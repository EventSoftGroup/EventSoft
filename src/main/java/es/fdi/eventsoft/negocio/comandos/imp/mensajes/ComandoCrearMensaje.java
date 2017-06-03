package es.fdi.eventsoft.negocio.comandos.imp.mensajes;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.entidades.Mensaje;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.CREAR_MENSAJE;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_CREAR_MENSAJE;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoCrearMensaje implements Comando {

    public Contexto execute(Object datos){
        Contexto contex;

        Long id = FactoriaSA.getInstance().crearSAMensajes().crearMensaje((Mensaje) datos);
        (contex = new Contexto()).setDatos(id);
        contex.setEvento((id>0) ? CREAR_MENSAJE : ERROR_CREAR_MENSAJE);

        return contex;
    }

}
