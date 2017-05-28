package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios;
import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import javafx.util.Pair;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.PortUnreachableException;
import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.*;

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