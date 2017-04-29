package es.fdi.eventsoft.negocio.factoriaSA;

import es.fdi.eventsoft.negocio.Usuario.SAUsuario;

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
