package es.fdi.eventsoft.negocio.comandos.imp.mensajes;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import javafx.util.Pair;

import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.BUSCAR_MENSAJES_BY_USER;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_BUSCAR_USUARIO;

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