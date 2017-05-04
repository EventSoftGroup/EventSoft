package es.fdi.eventsoft.negocio.servicios.imp;

import es.fdi.eventsoft.negocio.servicios.FactoriaSA;
import es.fdi.eventsoft.negocio.servicios.Servicio;

public class FactoriaSAImp extends FactoriaSA {
    @Override
    public Servicio crearServicio(TiposServicios entidad) {
        Servicio servicio = null;

        switch (entidad) {
            case USUARIO:
                servicio = new ServicioUsuarios();
                break;
        }

        return servicio;
    }
}
