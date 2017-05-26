package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios;
import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarServiciosByProveedor implements Comando {

    public Contexto execute(Object datos){

        List listaServicios = FactoriaSA.getInstance().crearSAServicios().buscarServiciosByProveedor((Proveedor) datos);

        if (listaServicios == null) {
            return new Contexto(EventosNegocio.ERROR_BUSCAR_SERVICIO, listaServicios);
        }

        return new Contexto(EventosNegocio.BUSCAR_SERVICIO, listaServicios);
    }

}