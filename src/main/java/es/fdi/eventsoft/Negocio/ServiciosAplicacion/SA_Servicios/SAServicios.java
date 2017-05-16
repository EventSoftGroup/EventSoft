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

    public int crearServicio(Servicio servicioNuevo) throws ExcepcionNegocio;

    public Servicio buscarServicio(Servicio servicio) throws ExcepcionNegocio;

    public int eliminarServicio(Servicio servicio) throws ExcepcionNegocio;

    public int modificarServicio(Servicio servicioModificado) throws ExcepcionNegocio;

    public List<Servicio> buscarServiciosByProveedor(Proveedor proveedor) throws ExcepcionNegocio;

    public List buscarServiciosByEvento(Evento evento);

    public List buscarServiciosEntreFechas(Date fecha_Ini, Date fecha_Fin) throws ExcepcionNegocio;

}
