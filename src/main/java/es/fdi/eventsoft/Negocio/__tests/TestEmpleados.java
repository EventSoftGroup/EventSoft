package es.fdi.eventsoft.Negocio.__tests;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Empleado;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Mensaje;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import javafx.scene.input.Mnemonic;
import javafx.util.Pair;
import org.springframework.util.SerializationUtils;
import sun.util.cldr.CLDRLocaleDataMetaInfo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.BUSCAR_MENSAJES_BY_USER;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_BUSCAR_USUARIO;


/**
 * Created by Tomas on 24/04/2017.
 */



public class TestEmpleados {


    public static void main(String[] args) {
//




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
        System.out.println();
    }

    private static void imprimirClientes(FachadaIntegracion<Cliente> SI) {
        List<Cliente> emps = SI.listado();
        System.out.println("Hay " + emps.size() + " clientes en el sistema");
        for (Cliente emp : emps) {
            System.out.println(emp.toString());
        }
    }


    private static void imprimirOrgans(FachadaIntegracion<Organizador> SI) {
        List<Organizador> emps = SI.listado();
        System.out.println("Hay " + emps.size() + " Organizadores en el sistema");
        for (Organizador emp : emps) {
            System.out.println(emp.toString());
        }
    }



}
