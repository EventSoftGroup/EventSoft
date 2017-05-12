package es.fdi.eventsoft.Negocio.__tests;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Or;
import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Empleado;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;

import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by Tomas on 24/04/2017.
 */



public class TestEmpleados {


    public static void main(String[] args) {


        /* Creamos el gestor de persistencia (EM) */

        persistirEmpleado(null);

    }

    public static void persistirEmpleado(Empleado emp) {

//        FachadaIntegracion fiCliente = FachadaIntegracion.newInstance(Empleado.class);
//        fiCliente.alta(new Empleado("desde holiii", "prueba4", new GregorianCalendar(1979,6,6).getTime(), "rodri@ucm.es"));



        FachadaIntegracion fiCliente = FachadaIntegracion.newInstance(Cliente.class);
        FachadaIntegracion fiOrgan = FachadaIntegracion.newInstance(Organizador.class);
        //FachadaIntegracion fiOrgan = FachadaIntegracion.newInstance(Organizador.class);
        FachadaIntegracion fiVal = FachadaIntegracion.newInstance(Valoracion.class);

        //Cliente cliente1 = new Cliente("CLiente20", "apellido");
        //fiCliente.alta(cliente1);


        //imprimirClientes(fiCliente);



        //Organizador organ1 = new Organizador("Organiz20", null);

        //fiOrgan.alta(organ1);



        Cliente cliente1 = (Cliente) fiCliente.consulta(1L);

        System.out.println(cliente1);

        System.out.println();




        Organizador organ4 = (Organizador) fiOrgan.consulta(4L);
        System.out.println(organ4);
        Organizador organ6 = (Organizador) fiOrgan.consulta(6L);
        System.out.println(organ6);

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
