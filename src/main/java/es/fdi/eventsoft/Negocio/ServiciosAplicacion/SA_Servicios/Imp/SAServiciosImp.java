package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios.Imp;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios.SAServicios;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;
import javafx.util.Pair;
import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.FacesRequestAttributes;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.BUSCAR_SERVICIOS_BY_PROVEEDOR;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_BUSCAR_SERVICIO;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_BUSCAR_USUARIO;
import static java.lang.System.out;

public class SAServiciosImp implements SAServicios{

    @Override
    public Long crearServicio(Servicio servicioNuevo) {
        Object result = null;
        //Buscamos si existe el proveedor del nuevo servicio
        Object proveedor = FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByID(servicioNuevo.getProveedor().getId());
        //Si si existe
        if(proveedor != null){
            //Creamos una nueva fachada de servicios
            FachadaIntegracion integra = FachadaIntegracion.newInstance(Servicio.class);
            integra.begin();
            //hacemos el alte
            result = integra.alta(servicioNuevo);
            integra.commit();
            //Si se ha realizado correctamente, devolvemos su id
            if((Servicio)result != null)
                return ((Servicio) result).getId();
            else //Si no, devolvemos null
                return null;
        }
        else { //Si no existe, devolvemos null
            return null;
        }

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
    public List<Servicio> buscarServiciosByProveedor(Proveedor prov) {
        List<Servicio> lista = null;
        FachadaIntegracion integra;
        Proveedor finalProveedor;

        if(prov == null) return null;

        try {
            if (prov.getEmail() != null) finalProveedor = (Proveedor) FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByEmail(prov.getEmail());
            else if (prov.getId() != null) finalProveedor =(Proveedor) FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByID(prov.getId());
            else return lista;

            if(finalProveedor == null) return null;
                integra = FachadaIntegracion.newInstance(Servicio.class);
                integra.begin();
                lista = integra.ejecutarNamedQuery("Servicio.buscarByProveedor", Arrays.asList(new Pair<>("proveedor", finalProveedor)));
                integra.commit();

                finalProveedor.setServicios(null);

                //Stream para limpiar los servicios de la BBDD
                lista.stream().map((serv) -> {
                    serv.setProveedor(finalProveedor);
                    serv.setEventoServicios(null);
                    return serv;
                }).count();

        }catch (ClassCastException e){
            return null;
        }

        return lista;
    }

    @Override
    public List<Servicio> buscarServiciosByTipoServicio(Servicio.TiposServicio tipoServicio) {
        FachadaIntegracion integra =FachadaIntegracion.newInstance(Servicio.class);

        integra.begin();
        List<Servicio> lista = integra.ejecutarNamedQuery("Servicio.buscarPorTipoServicio", Arrays.asList(new Pair<>("tipoServicio", tipoServicio)));
        integra.commit();

        //El siguiente for es una guarreria de codigo, pero la carga LAZY no funciona bien y la EAGER genera buble infinito
        for(Servicio serv: lista) {
            serv.setProveedor(null);
            serv.setEventoServicios(null);
        }

        return lista;
    }

    @Override
    public List buscarServiciosByEvento(Evento evento) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Servicio.class);

        fachadaIntegracion.begin();
        List servicios = fachadaIntegracion.ejecutarNamedQuery("Servicio.buscarPorEvento", Arrays.asList(new Pair<>("evento", evento)));
        fachadaIntegracion.commit();

        return servicios;
    }

    @Override
    public List<Servicio> buscarServiciosEntreFechas(ArrayList<String> fechas) {
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        ArrayList<Pair> fechasNuevas = new ArrayList<>();

        try {
            Date fechaIni = format.parse(fechas.get(0));
            Date fechaFin = format.parse(fechas.get(1));

            fechasNuevas.add(new Pair("fechaIni", fechaIni));
            fechasNuevas.add(new Pair("fechaFin", fechaFin));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Servicio.class);

        fachadaIntegracion.begin();
        List servicios = fachadaIntegracion.ejecutarNamedQuery("Servicio.buscarEntreFechas", Arrays.asList(fechasNuevas));
        fachadaIntegracion.commit();

        return servicios;
    }
}
