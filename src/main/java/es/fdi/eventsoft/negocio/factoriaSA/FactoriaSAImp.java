package es.fdi.eventsoft.negocio.factoriaSA;

import es.fdi.eventsoft.negocio.Usuario.SAUsuario;
import es.fdi.eventsoft.negocio.Usuario.SAUsuarioImp;

/**
 * Created by Tomas on 29/04/17.
 */
public class FactoriaSAImp extends FactoriaSA {

        public SAUsuario crearSAUsuario() {
            return new SAUsuarioImp();
        }
}
