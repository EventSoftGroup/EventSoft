package es.fdi.eventsoft.negocio.comandos.imp.eventos;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarEventosByUser implements Comando {

    public Contexto execute(Object datos){
        List listaEventos = FactoriaSA.getInstance().crearSAEventos().buscarEventosByUsuario((Usuario) datos);

        return new Contexto(EventosNegocio.BUSCAR_EVENTOS_BY_USUARIO, listaEventos);
    }

}