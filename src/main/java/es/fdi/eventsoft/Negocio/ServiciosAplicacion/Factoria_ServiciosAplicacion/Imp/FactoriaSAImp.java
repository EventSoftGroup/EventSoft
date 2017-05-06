package es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.Imp;

import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.Imp.SAUsuarioImp;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;

/**
 * Created by Tomas on 29/04/17.
 */
public class FactoriaSAImp extends FactoriaSA {

    public SAUsuario crearSAUsuario(){
        return new SAUsuarioImp();
    }
}
