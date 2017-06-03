package es.fdi.eventsoft.negocio.comandos.imp.servicios;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.usuario.Proveedor;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoBuscarServiciosByProveedor implements Comando {

    public Contexto execute(Object datos){
        List listaServicios = null;
        EventosNegocio evento = ERROR_BUSCAR_USUARIO;
        Proveedor prov = null;

        if(datos != null && (datos instanceof Proveedor || datos instanceof Long) ){

            if(datos instanceof Long)
                prov = new Proveedor((Long) datos);
            else if (datos instanceof Proveedor)
                prov = (Proveedor) datos;

            listaServicios = FactoriaSA.getInstance().crearSAServicios().buscarServiciosByProveedor(prov);
            if (listaServicios != null) evento = BUSCAR_SERVICIOS_BY_PROVEEDOR;
            else evento = ERROR_BUSCAR_SERVICIO;

        }

        return new Contexto(evento, listaServicios);
    }

}