package es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Usuarios;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;

import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_LISTAR_USUARIOS;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.LISTAR_USUARIOS;

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
