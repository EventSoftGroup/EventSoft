package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Mensajes;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.CREAR_MENSAJE;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_CREAR_MENSAJE;

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
