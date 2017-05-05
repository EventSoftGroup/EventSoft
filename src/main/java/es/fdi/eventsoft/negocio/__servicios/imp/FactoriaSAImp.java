package es.fdi.eventsoft.negocio.__servicios.imp;

import es.fdi.eventsoft.Integracion.imp.ServicioIntegracionImp;
import es.fdi.eventsoft.negocio.__servicios.FactoriaSA;

public class FactoriaSAImp extends FactoriaSA {
    @Override
    public ServicioIntegracionImp crearServicio(TiposServicios entidad) {
        ServicioIntegracionImp servicioIntegracionImp = null;

        switch (entidad) {
            case USUARIO:
                servicioIntegracionImp = new __ServicioUsuarios();
                break;
        }

        return servicioIntegracionImp;
    }
}
