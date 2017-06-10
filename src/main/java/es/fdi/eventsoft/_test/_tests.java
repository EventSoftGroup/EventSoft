package es.fdi.eventsoft._test;

import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Organizador;
import es.fdi.eventsoft.negocio.servicios.eventos.SAEventos;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import javafx.util.Pair;
import sun.security.jgss.krb5.ServiceCreds;

import javax.naming.CompositeName;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by Tomas on 24/04/2017.
 */
public class _tests {


    public static void main(String[] args) throws ParseException {


        EventosNegocio evnt = FactoriaSA.getInstance().crearSAEventos().añadirServiciosAEvento(19L, Arrays.asList(38L));

        System.out.println(evnt);


        testCrearEvento();

/*      Date fecha = formateaFecha("2017-06-03");
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
//        Proveedor p = new Proveedor(5L);
//        Contexto c =  FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_SERVICIOS_BY_PROVEEDOR).execute(p);
//        List listaServicios = (List) c.getDatos();
//
//        for (int i = 0; i < listaServicios.size(); i++) {
//            Servicio miservicio = (Servicio) listaServicios.get(i);
//            System.out.println(miservicio.getDescripcion());
//            List listaES = (List) miservicio.getEventoServicios();
//            for (int j = 0; j < listaES.size(); j++){
//                EventoServicio es = (EventoServicio) listaES.get(j);
//                System.out.println(es.getEvento().getId());
//            }
//        }

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

    private static void testCrearEvento() {
        Evento evento = new Evento();
        Cliente cli;
        Organizador org;
        EventosNegocio result;
        Comando comando = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_EVENTO);
        SAEventos sa = FactoriaSA.getInstance().crearSAEventos();
        List<EventosNegocio> lista = new ArrayList();


        org = new Organizador(); org.setId(9L); evento.setOrganizador(org);

        //email inexistente
        cli = new Cliente(); cli.setEmail("asdfsdf@sdfadfafsdf.asdfasfasfasdfa");
        evento.setCliente(cli);
        lista.add(comando.execute(evento).getEvento());



        //Cliente valido
        cli = new Cliente(); cli.setEmail("fer_marugan@hotmail.com");
        evento.setCliente(cli);
        lista.add(comando.execute(evento).getEvento());




        //cliente email--> null
        cli = new Cliente(); cli.setEmail(null);
        evento.setCliente(cli);
        lista.add(comando.execute(evento).getEvento());


        //cliente --> null
        cli = new Cliente();
        evento.setCliente(null);
        lista.add(comando.execute(evento).getEvento());


        //Cliente --> Organizador
        cli = new Cliente(); cli.setEmail("eventos@hotmail.com");
        evento.setCliente(cli);
        lista.add(comando.execute(evento).getEvento());


        //cliente --> proveedor
        cli = new Cliente(); cli.setEmail("proveedor@hotmail.com");
        evento.setCliente(cli);
        lista.add(comando.execute(evento).getEvento());




        cli = new Cliente(); cli.setEmail("fer_marugan@hotmail.com");
        evento.setCliente(cli);

        //org valido
        org = new Organizador(); org.setId(9L);
        evento.setOrganizador(org);
        lista.add(comando.execute(evento).getEvento());

        //Org --> null
        org = null;
        evento.setOrganizador(org);
        lista.add(comando.execute(evento).getEvento());

        //org --> no existe
        org = new Organizador(); org.setId(900000L);
        evento.setOrganizador(org);
        lista.add(comando.execute(evento).getEvento());


        //org --> cliente/ proveed
        org = new Organizador(); org.setId(8L);
        evento.setOrganizador(org);
        lista.add(comando.execute(evento).getEvento());


        final int[] cont = {0};
        lista.stream().forEach((event)-> {
            cont[0] += 1;
            System.out.println("Test " + cont[0] + ": " + event);
        });

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
