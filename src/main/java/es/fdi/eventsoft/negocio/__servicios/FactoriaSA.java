package es.fdi.eventsoft.negocio.__servicios;

import es.fdi.eventsoft.Integracion.imp.ServicioIntegracionImp;
import es.fdi.eventsoft.negocio.__servicios.imp.FactoriaSAImp;

public abstract class FactoriaSA {

    private static FactoriaSA factoriaSA;

    public enum TiposServicios {
        USUARIO
    }



    public static FactoriaSA obtenerInstancia() {
        if (factoriaSA == null) {
             factoriaSA = new FactoriaSAImp();
        }

        return factoriaSA;
    }

    public abstract ServicioIntegracionImp crearServicio(TiposServicios entidad);
}
