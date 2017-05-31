package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Mensajes;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import javafx.util.Pair;

import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.BUSCAR_MENSAJES_BY_USER;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_BUSCAR_USUARIO;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarMensajesByUser implements Comando {

    public Contexto execute(Object datos){
        Pair<Usuario, Boolean> par = (Pair) datos;

        List listaMensajes = FactoriaSA.getInstance().crearSAMensajes().buscarMensajesByUser(par.getKey(), par.getValue());

        return new Contexto((listaMensajes != null) ? BUSCAR_MENSAJES_BY_USER : ERROR_BUSCAR_USUARIO, listaMensajes);
    }

}