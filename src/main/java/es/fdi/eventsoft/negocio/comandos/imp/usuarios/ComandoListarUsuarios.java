package es.fdi.eventsoft.negocio.comandos.imp.usuarios;



import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;

import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.ERROR_LISTAR_USUARIOS;
import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.LISTAR_USUARIOS;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class ComandoListarUsuarios implements Comando {

    public Contexto execute(Object datos) {
        List lista = null;

        try {
            lista = FactoriaSA.getInstance().crearSAUsuarios().listarUsuariosByTipo((Class<? extends Usuario>) datos);

        } catch (ClassCastException e) {
            return new Contexto(EventosNegocio.ERROR_LISTAR_USUARIOS, lista);
        }

        return new Contexto((lista == null)? ERROR_LISTAR_USUARIOS: LISTAR_USUARIOS, lista);
    }
}
