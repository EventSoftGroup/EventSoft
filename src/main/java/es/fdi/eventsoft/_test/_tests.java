package es.fdi.eventsoft._test;

import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.EventoServicio;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Proveedor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Tomas on 24/04/2017.
 */
public class _tests {


    public static void main(String[] args) throws ParseException {

/*
        Date fecha = formateaFecha("2017-06-03");
        System.out.println(fecha);


        fecha = formateaFecha("03/06/2017");
        System.out.println(fecha);


        Calendar cal = Calendar.getInstance();
        String dateInString = new java.text.SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss").format(cal.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");

        Date parsedDate = null;
        try {
            parsedDate = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(parsedDate);

        Date myDate = new Date();
        System.out.println(myDate);
        System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(myDate));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
        System.out.println(myDate);


        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(cal.getTime());
        // Output "Wed Sep 26 14:23:28 EST 2012"

        String formatted = format1.format(cal.getTime());
        System.out.println(formatted);
        // Output "2012-09-26"

        try {
            System.out.println(format1.parse(formatted));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Output "Wed Sep 26 00:00:00 EST 2012"
*/
        //Creamos un servicio
        Proveedor p = new Proveedor(5L);
        Contexto c =  FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_SERVICIOS_BY_PROVEEDOR).execute(p);
        List listaServicios = (List) c.getDatos();

        for (int i = 0; i < listaServicios.size(); i++) {
            Servicio miservicio = (Servicio) listaServicios.get(i);
            System.out.println(miservicio.getDescripcion());
            List listaES = (List) miservicio.getEventoServicios();
            for (int j = 0; j < listaES.size(); j++){
                EventoServicio es = (EventoServicio) listaES.get(j);
                System.out.println(es.getEvento().getId());
            }
        }

        /*Servicio serv = new Servicio(Servicio.TiposServicio.DJ, "Dj FER", "el mejor dj de espaÃ±a", new Date(),(Proveedor) c.getDatos());
        c  = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_SERVICIO).execute(serv);
        //Lo mostramos
        Long id = (Long)c.getDatos();
        if( id != null){
            System.out.println(id);
            //Lo eliminamos
            //c = FactoriaComandos.getInstance().crearComando(EventosNegocio.ELIMINAR_SERVICIO).execute(id);
            //String resp = (String) c.getDatos();
            //System.out.println(resp);
        }
    */

    }


    private static Date formateaFecha(String fechaInicio) {

        DateFormat dateFormat;
        Date fecha = null;

        try {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            fecha = dateFormat.parse(fechaInicio);
        } catch (ParseException e) {

            try {
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                fecha = dateFormat.parse(fechaInicio);
            } catch (ParseException e1) {
                fecha = null;
            }
        }

        return fecha;
    }


    public static void pruebaCapacidadThreads() {


        FachadaIntegracion integracion = FachadaIntegracion.newInstance(Cliente.class);

        int tam = 30;
        List<Long> list = new ArrayList<>();

        long time_start, time_end;
        time_start = System.currentTimeMillis();
        for (int i = 0; i < tam; i++) {
            //list.add(lanzarPruebaThreads());
        }
        time_end = System.currentTimeMillis();

        System.out.println("********************************************");
        System.out.println(tam + " ejecuciones CON HILOS --> " + (time_end - time_start) + " ms. MEDIA: " + (time_end - time_start) / tam);
        System.out.println("********************************************");

        list.stream().forEach((time) -> System.out.println("The task has taken " + (time) + " milliseconds"));


    }



}
