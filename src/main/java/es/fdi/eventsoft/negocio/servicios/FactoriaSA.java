package es.fdi.eventsoft.negocio.servicios;

import es.fdi.eventsoft.negocio.servicios.imp.FactoriaSAImp;
import es.fdi.eventsoft.negocio.servicios.imp.TiposServicios;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class FactoriaSA {
    protected static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("eventsoft");
    private static FactoriaSA factoriaSA;

    public static FactoriaSA obtenerInstancia() {
        if (factoriaSA == null) {
             factoriaSA = new FactoriaSAImp();
        }

        return factoriaSA;
    }

    public abstract Servicio crearServicio(TiposServicios entidad);
}
