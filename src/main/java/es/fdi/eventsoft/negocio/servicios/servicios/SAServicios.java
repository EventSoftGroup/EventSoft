package es.fdi.eventsoft.negocio.servicios.servicios;

import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Proveedor;
import es.fdi.eventsoft.negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAServicios {

    Long crearServicio(Servicio servicioNuevo);

    Servicio buscarServicio(Long id) ;

    int eliminarServicio(Long servicio);

    int modificarServicio(Servicio servicioModificado) throws ExcepcionNegocio;

    List<Servicio> buscarServiciosByProveedor(Proveedor proveedor);

    List<Servicio> buscarServiciosByTipoServicio(Servicio.TiposServicio tiposServicio);

    List buscarServiciosByEvento(Evento evento);

    List buscarServiciosEntreFechas(ArrayList<String> fechas);

}
