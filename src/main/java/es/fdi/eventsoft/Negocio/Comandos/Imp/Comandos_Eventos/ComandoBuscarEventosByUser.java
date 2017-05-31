package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Eventos;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

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