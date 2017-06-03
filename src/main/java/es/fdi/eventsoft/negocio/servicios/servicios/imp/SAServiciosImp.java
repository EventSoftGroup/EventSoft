package es.fdi.eventsoft.negocio.servicios.servicios.imp;


import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.EventoServicio;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Proveedor;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import es.fdi.eventsoft.negocio.servicios.servicios.SAServicios;
import javafx.util.Pair;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Servicio servicio = null;

        if(id != null) {
            FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Servicio.class);

            fachadaIntegracion.begin();
            servicio = (Servicio) fachadaIntegracion.consulta(id);
            fachadaIntegracion.commit();
        }

        return servicio;
    }

    private int numEventosVencidos(List<EventoServicio> listaEvenServ) {
        Iterator<EventoServicio> it = listaEvenServ.iterator();
        Evento act;
        Date fechaAct = new Date();
        int cont = 0;
        while (it.hasNext()) {
            //Obtenemos el evento actual
            act = it.next().getEvento();
            //Si la fecha de fin es anterior a la fecha actual
            if (act.getFechaFin().before(fechaAct)) {
                cont++;
            }
        }
        return cont;
    }/*
    private void eliminarEventosServicios(List<EventoServicio> lista) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(EventoServicio.class);
        boolean ok = true;
        Iterator<EventoServicio> it = lista.iterator();
        Long act;
        while (it.hasNext()) {
            //Obtenemos el evento actual
            ClavesEventoServicio = it.next().getId();
            fachadaIntegracion.begin();
            ok = fachadaIntegracion.baja(act);
            fachadaIntegracion.commit();
        }
    }*/
    @Override
    public int eliminarServicio(Long servicio){
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Servicio.class);

        //La respuesta podran ser tres cosas:
        //0 -> Si se elimino el servicio correctamente
        //1 -> Si no se encontro el servicio a eliminar
        //2 -> Si el servicio tiene eventos asociados
        int respuesta;
        boolean ok;
        Servicio s = buscarServicio(servicio);

        //Si el servicio existe...
        if(s != null){
            //Recuperamos y recorremos su lista de EventoServicio para saber a que eventos esta asociado
            List<EventoServicio> listaEventoServicio = s.getEventoServicios();

            //Si no tiene eventos asociados, eliminamos el servicio
            if(listaEventoServicio == null){
                fachadaIntegracion.begin();
                ok = fachadaIntegracion.baja(servicio);
                fachadaIntegracion.commit();

                if(ok){respuesta = 0;}
                else {respuesta = 1;}

            }
            //Si tiene eventos asociados
            else{
                int cont = numEventosVencidos(listaEventoServicio);
                //Si todos los eventos que tiene asociados son pasados, eliminamos
                if(listaEventoServicio.size() == cont){
                    //Primero, eliminamos sus EventoServicio
                    //eliminarEventosServicios(listaEventoServicio);
                    //Y, despues, eliminamos el servicio
                    fachadaIntegracion.begin();
                    ok = fachadaIntegracion.baja(servicio);
                    fachadaIntegracion.commit();

                    if(ok){respuesta = 0;}
                    else {respuesta = 2;}
                }
                else //En caso contrario, devolvemos un error
                    respuesta = 2;
            }
        }
        //Si no encuentra el servicio
        else
            respuesta = 1;

        return respuesta;
    }

    @Override
    public int modificarServicio(Servicio servicioModificado) {
        //TODO
        return 0;
    }

    @Override
    public List<Servicio> listarServicios() {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(Servicio.class);
        List<Servicio> lista = null;

        integra.begin();
        lista = integra.listado();

        lista.stream().forEach((serv)-> {
            serv.getProveedor().getEmail();
            serv.setEventoServicios(null);
        });
        integra.commit();

        return lista;
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
