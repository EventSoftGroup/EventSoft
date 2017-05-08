package es.fdi.eventsoft.Negocio.__tests;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Empleado;
import org.springframework.ui.Model;

import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by Tomas on 24/04/2017.
 */



public class TestEmpleados {


    public static void main(String[] args) {


        /* Creamos el gestor de persistencia (EM) */

        persistirEmpleado(new Empleado("desde Main", "prueba2", new GregorianCalendar(1979,6,6).getTime()));

    }

    public static void persistirEmpleado(Empleado emp) {

        FachadaIntegracion FI = FachadaIntegracion.newInstance(Empleado.class);

        FI.alta(emp);

        imprimirTodo(FI);
    }


    private static void imprimirTodo(FachadaIntegracion<Empleado> SI) {
        List<Empleado> emps = SI.listado();
        System.out.println("Hay " + emps.size() + " empleados en el sistema");
        for (Empleado emp : emps) {
            System.out.println(emp.toString());
        }
    }

}
