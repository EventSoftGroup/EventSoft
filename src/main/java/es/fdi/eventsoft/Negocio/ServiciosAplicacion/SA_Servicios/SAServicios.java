package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios;

import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAServicios {

    Long crearServicio(Servicio servicioNuevo);

    Servicio buscarServicio(Long id) ;

    boolean eliminarServicio(Long servicio);

    int modificarServicio(Servicio servicioModificado) throws ExcepcionNegocio;

    List<Servicio> buscarServiciosByProveedor(Proveedor proveedor);

    List<Servicio> buscarServiciosByTipoServicio(Servicio.TiposServicio tiposServicio);

    List buscarServiciosByEvento(Evento evento);

    List buscarServiciosEntreFechas(ArrayList<String> fechas);

}
