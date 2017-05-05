package es.fdi.eventsoft.negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.Imp;

import es.fdi.eventsoft.negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.negocio.ServiciosAplicacion.ServicioAplicacion_Usuario.SAUsuario;
import es.fdi.eventsoft.negocio.ServiciosAplicacion.ServicioAplicacion_Usuario.SAUsuarioImp;

/**
 * Created by Tomas on 29/04/17.
 */
public class FactoriaSAImp extends FactoriaSA {

        public SAUsuario crearSAUsuario() {
            return new SAUsuarioImp();
        }
}
