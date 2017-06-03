package es.fdi.eventsoft.Negocio.__tests;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Empleado;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.*;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import javafx.util.Pair;
import org.omg.CORBA.TIMEOUT;
import org.springframework.ui.Model;
import sun.util.cldr.CLDRLocaleDataMetaInfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.*;
import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.setOut;


/**
 * Created by Tomas on 24/04/2017.
 */


public class TestEmpleados {


    public static void main(String[] args) throws ParseException {


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
            list.add(lanzarPruebaThreads());
        }
        time_end = System.currentTimeMillis();

        System.out.println("********************************************");
        System.out.println(tam + " ejecuciones CON HILOS --> " + (time_end - time_start) + " ms. MEDIA: " + (time_end - time_start) / tam);
        System.out.println("********************************************");

        list.stream().forEach((time) -> System.out.println("The task has taken " + (time) + " milliseconds"));


    }


    public static long lanzarPruebaThreads() {


//        Contexto[] contexListarClientes = new Contexto[1];
//        contexListarClientes[0] = FactoriaComandos.getInstance().crearComando(LISTAR_USUARIOS).execute(Cliente.class);
//
//        Contexto[] contexListarProveedores = new Contexto[1];
//        contexListarProveedores[0] = FactoriaComandos.getInstance().crearComando(LISTAR_USUARIOS).execute(Proveedor.class);
//
//        Contexto[] contexListarOrganizadores  = new Contexto[1];
//        contexListarOrganizadores[0] = FactoriaComandos.getInstance().crearComando(LISTAR_USUARIOS).execute(Organizador.class);
//
//        Contexto[] contexCountMensajes = new Contexto[1];
//        contexCountMensajes[0] = FactoriaComandos.getInstance().crearComando(COUNT_MENSAJES).execute(null);
//
//        Contexto[] contexListarServicios = new Contexto[1];
//        contexListarServicios[0] = FactoriaComandos.getInstance().crearComando(LISTAR_SERVICIOS).execute(null);
//
//        Contexto[] contexListarEventos = new Contexto[1];
//        contexListarEventos[0] = FactoriaComandos.getInstance().crearComando(LISTAR_EVENTOS).execute(null);

        long time_start, time_end;
        time_start = System.currentTimeMillis();


        Contexto[] contexListarClientes = new Contexto[1];
        Runnable hilo1 = () -> contexListarClientes[0] = FactoriaComandos.getInstance().crearComando(LISTAR_USUARIOS).execute(Cliente.class);

        Contexto[] contexListarProveedores = new Contexto[1];
        Runnable hilo2 = () -> contexListarProveedores[0] = FactoriaComandos.getInstance().crearComando(LISTAR_USUARIOS).execute(Proveedor.class);

        Contexto[] contexListarOrganizadores = new Contexto[1];
        Runnable hilo3 = () -> contexListarOrganizadores[0] = FactoriaComandos.getInstance().crearComando(LISTAR_USUARIOS).execute(Organizador.class);

        Contexto[] contexCountMensajes = new Contexto[1];
        Runnable hilo4 = () -> contexCountMensajes[0] = FactoriaComandos.getInstance().crearComando(COUNT_MENSAJES).execute(null);

        Contexto[] contexListarServicios = new Contexto[1];
        Runnable hilo5 = () -> contexListarServicios[0] = FactoriaComandos.getInstance().crearComando(LISTAR_SERVICIOS).execute(null);

        Contexto[] contexListarEventos = new Contexto[1];
        Runnable hilo6 = () -> contexListarEventos[0] = FactoriaComandos.getInstance().crearComando(LISTAR_EVENTOS).execute(null);

        Stream<Runnable> flujo = Stream.of(hilo1, hilo2, hilo3, hilo4, hilo5, hilo6);
        ExecutorService executor = Executors.newCachedThreadPool();

        flujo.forEach(executor::execute);
        executor.shutdown();
        try {
            if (executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                System.out.println();
                System.out.println("*******************************************************************************************************************");
                System.out.println("*******************************************************************************************************************");
                System.out.println();
                System.out.println(contexListarClientes[0].getEvento() + " --> " + ((List) contexListarClientes[0].getDatos()).size());
                System.out.println(contexListarOrganizadores[0].getEvento() + " --> " + ((List) contexListarOrganizadores[0].getDatos()).size());
                System.out.println(contexListarProveedores[0].getEvento() + " --> " + ((List) contexListarProveedores[0].getDatos()).size());

                System.out.println(contexListarServicios[0].getEvento() + " --> " + ((List) contexListarServicios[0].getDatos()).size());
                System.out.println(contexListarEventos[0].getEvento() + " --> " + ((List) contexListarEventos[0].getDatos()).size());

                System.out.println(contexCountMensajes[0].getEvento() + " --> " + ((Long) contexCountMensajes[0].getDatos()));
                System.out.println();
                System.out.println("*******************************************************************************************************************");
                System.out.println("*******************************************************************************************************************");
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        time_end = System.currentTimeMillis();
        return (time_end - time_start);
    }


    public static void persistirEmpleado(Empleado emp) {

//        FachadaIntegracion fiCliente = FachadaIntegracion.newInstance(Empleado.class);
//        fiCliente.alta(new Empleado("desde holiii", "prueba4", new GregorianCalendar(1979,6,6).getTime(), "rodri@ucm.es"));


        //FachadaIntegracion integra = FachadaIntegracion.newInstance(Usuario.class);




        /*
        FachadaIntegracion fiOrgan = FachadaIntegracion.newInstance(Organizador.class);
        //FachadaIntegracion fiOrgan = FachadaIntegracion.newInstance(Organizador.class);
        FachadaIntegracion fiVal = FachadaIntegracion.newInstance(Valoracion.class);

        fiCliente.begin();

        Cliente cliente1 = new Cliente("CLiente1", "apellido", null, null);
        fiCliente.alta(cliente1);
        cliente1 = (Cliente) fiCliente.consulta(2L);

        fiCliente.commit();

        //imprimirClientes(fiCliente);

        fiOrgan.begin();
        Organizador organ1 = new Organizador("Organiz1", "12345678", null);

        fiOrgan.alta(organ1);



        organ1 = (Organizador) fiOrgan.consulta(3L);
        //Organizador organ6 = (Organizador) fiOrgan.consulta(6L);
        //System.out.println(organ6);

        fiOrgan.commit();

        fiVal.begin();
        Valoracion val1 = new Valoracion(cliente1, organ1, new GregorianCalendar(1979,6,6).getTime(), 4, "Valoracion de puta madre");

        //System.out.println(val1);
        fiVal.alta(val1);
        //Organizador organ1 = new Organizador("Organiz20", null);

        //fiOrgan.alta(organ1);

        fiVal.commit();
        */
//
//
//        fiCliente.begin();
//        Cliente cliente1 = (Cliente) fiCliente.consulta(2L);
//
//        System.out.println(cliente1);
//
//
//        System.out.println(cliente1.getValoraciones_hechas().size());
//        fiCliente.commit();
//
//
//
//        fiOrgan.begin();
//
//        Organizador orgNuevo = (Organizador) fiOrgan.consulta(3L);
//
//        System.out.println(orgNuevo.getValoraciones_recibidas().size());
//
//        fiOrgan.commit();
//
//
//
//        fiVal.begin();
//        Valoracion val = (Valoracion) fiVal.consulta(2L);
//
//        System.out.println(val);
//
//        System.out.println(val.getCliente());
//
//        List<Valoracion> lista = val.getCliente().getValoraciones_hechas();
//
//        System.out.println(lista.size());
//        for (Valoracion valo : lista) {
//            System.out.println(valo.toString());
//        }
//        fiVal.commit();
//
//
//
//
//
//

        //Organizador organ4 = (Organizador) fiOrgan.consulta(4L);
        //System.out.println(organ4);
        //Organizador organ6 = (Organizador) fiOrgan.consulta(6L);
        //System.out.println(organ6);

/*
        Valoracion val1 = new Valoracion(cliente1, organ6, 40);

        System.out.println(val1);
        fiVal.alta(val1);
*/
        //System.out.println(fiVal.consulta(1L));
        out.println();
    }

    private static void imprimirClientes(FachadaIntegracion<Cliente> SI) {
        List<Cliente> emps = SI.listado();
        out.println("Hay " + emps.size() + " clientes en el sistema");
        for (Cliente emp : emps) {
            out.println(emp.toString());
        }
    }


    private static void imprimirOrgans(FachadaIntegracion<Organizador> SI) {
        List<Organizador> emps = SI.listado();
        out.println("Hay " + emps.size() + " Organizadores en el sistema");
        for (Organizador emp : emps) {
            out.println(emp.toString());
        }
    }


}
