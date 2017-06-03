package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Eventos;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.BUSCAR_SERVICIO;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_BUSCAR_SERVICIO;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoListarEventos implements Comando {

    public Contexto execute(Object datos){
        return new Contexto(EventosNegocio.LISTAR_EVENTOS, FactoriaSA.getInstance().crearSAEventos().listarEventos());
    }

}
