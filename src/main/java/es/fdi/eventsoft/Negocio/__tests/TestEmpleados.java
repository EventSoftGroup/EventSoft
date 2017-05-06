package es.fdi.eventsoft.Negocio.__tests;

import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Empleado;

import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by Tomas on 24/04/2017.
 */



public class TestEmpleados {


    public static void main(String[] args) {


        /* Creamos el gestor de persistencia (EM) */


        Empleado e = new Empleado(100L, "fsdgasdfgadfv", "jimenaa", new GregorianCalendar(1979,6,6).getTime());
        Empleado e2 = new Empleado(90L);



        FachadaIntegracion FI = FachadaIntegracion.getInstance(Empleado.class);



        FI.alta(e);
        FI.baja(e.getCodigo());
        imprimirTodo(FI);

    }

    private static void imprimirTodo(FachadaIntegracion<Empleado> SI) {
        //List<Empleado> emps = (List<Empleado>) SI.ejecutarQuery("FROM Empleado");
        List<Empleado> emps = SI.listado();
        System.out.println("Hay " + emps.size() + " empleados en el sistema");
        for (Empleado emp : emps) {
            System.out.println(emp.toString());
        }
    }

}
