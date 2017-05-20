package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios.Imp;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios.SAServicios;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAServiciosImp implements SAServicios{

    @Override
    public int crearServicio(Servicio servicioNuevo) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public Servicio buscarServicio(Long id) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Servicio.class);

        fachadaIntegracion.begin();
        Servicio servicio = (Servicio) fachadaIntegracion.consulta(id);
        fachadaIntegracion.commit();

        return servicio;
    }

    @Override
    public int eliminarServicio(Servicio servicio) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public int modificarServicio(Servicio servicioModificado) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public List<Servicio> buscarServiciosByProveedor(Proveedor proveedor) throws ExcepcionNegocio {
        //TODO
        return null;
    }

    @Override
    public List buscarServiciosByEvento(Evento evento) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Servicio.class);

        fachadaIntegracion.begin();
        List servicios = fachadaIntegracion.ejecutarNamedQuery("Servicio.buscarPorEvento", Arrays.asList(new javafx.util.Pair<>("evento", evento)));
        fachadaIntegracion.commit();

        return servicios;
    }

    @Override
    public List<Servicio> buscarServiciosEntreFechas(Date fecha_Ini, Date fecha_Fin) {
        //TODO
        return null;
    }
}
