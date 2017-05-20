package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios;

import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.Date;
import java.util.List;

/**
 * Created by Rodrigo de Miguel on 06/05/2017.
 */
public interface SAServicios {

    int crearServicio(Servicio servicioNuevo) throws ExcepcionNegocio;

    Servicio buscarServicio(Servicio servicio) throws ExcepcionNegocio;

    int eliminarServicio(Servicio servicio) throws ExcepcionNegocio;

    int modificarServicio(Servicio servicioModificado) throws ExcepcionNegocio;

    List<Servicio> buscarServiciosByProveedor(Proveedor proveedor) throws ExcepcionNegocio;

    List buscarServiciosByEvento(Evento evento);

    List buscarServiciosEntreFechas(Date fecha_Ini, Date fecha_Fin);

}
