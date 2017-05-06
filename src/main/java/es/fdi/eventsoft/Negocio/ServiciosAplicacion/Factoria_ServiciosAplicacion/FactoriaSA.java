package es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion;

import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.Imp.FactoriaSAImp;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;

/**
 * Created by Tomas on 29/04/17.
 */
public abstract class FactoriaSA {

    private static FactoriaSA uniqueInstance;

    public static FactoriaSA getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new FactoriaSAImp();
        }

        return uniqueInstance;
    }



    public abstract SAUsuario crearSAUsuario();

}
