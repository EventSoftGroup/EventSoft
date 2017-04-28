package es.fdi.eventsoft.negocio.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.fdi.eventsoft.negocio.modelo.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by Tomas on 24/04/2017.
 */



public class TestEmpleados {



    private static EntityManager manager;

    private static EntityManagerFactory emf;

    public static void main(String[] args) {


        /* Creamos el gestor de persistencia (EM) */
        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();

        Empleado e = new Empleado(70L, "Teston", "Maria", new GregorianCalendar(1979,6,6).getTime());

        manager.getTransaction().begin();
        manager.persist(e);

        manager.getTransaction().commit();

        imprimirTodo();
        //session.beginTransaction();
        //session.close();

    }
    @SuppressWarnings("unchecked")
    private static void imprimirTodo() {
        List<Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        System.out.println("Hay " + emps.size() + " empleados en el sistema");
        for (Empleado emp : emps) {
            System.out.println(emp.toString());
        }
    }

}
