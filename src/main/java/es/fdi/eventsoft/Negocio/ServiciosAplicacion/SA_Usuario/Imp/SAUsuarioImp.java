package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.Imp;

import com.sun.org.apache.xpath.internal.operations.Or;
import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.*;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAUsuarioImp implements SAUsuario{

    public EventosNegocio crearUsuario(Usuario usuarioNuevo){

        Object result = null;
        FachadaIntegracion integra = null;

            //si no existe ya el correo...
            if (buscarUsuarioByEmail(usuarioNuevo.getEmail()) == null) {

                usuarioNuevo.setEstado(Usuario.EstadosUsuario.ACTIVO);

                integra = FachadaIntegracion.newInstance(Usuario.class);
                integra.begin();
                result = integra.alta(usuarioNuevo);
                integra.commit();

            }else{
                return EventosNegocio.EMAIL_YA_EXISTENTE;
            }

        return (result!=null) ? USUARIO_CREADO : ERROR_CREAR_USUARIO;
    }

    @Override
    public Usuario buscarUsuarioByID(Long id) {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(Usuario.class);

        integra.begin();
        Usuario user = (Usuario) integra.consulta(id);
        integra.commit();

        return user;
    }

    @Override
    public EventosNegocio eliminarUsuario(Usuario usuarioEliminar) {

        FachadaIntegracion integra = null;
        boolean result = false;


        try {

            //Se elimina solo si existe el correo
            Usuario aborrar = buscarUsuarioByEmail(usuarioEliminar.getEmail());
            if (aborrar != null) {
                integra = FachadaIntegracion.newInstance(Usuario.class);

                integra.begin();
                result = integra.baja(aborrar.getId());
                integra.commit();
            }


        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return (result == true) ? ELIMINAR_USUARIO : ERROR_ELIMINAR_USUARIO;
    }

    public Usuario buscarUsuarioByEmail(String email) {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(Usuario.class);

        integra.begin();
        List list = integra.ejecutarNamedQuery("Usuario.buscarPorEmail", Arrays.asList(new Pair<>("email", email)));
        integra.commit();

        return (list.isEmpty()) ? null : (Usuario) (list.iterator().next());
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Usuario.class);

        fachadaIntegracion.begin();
        fachadaIntegracion.modifica(usuario);
        fachadaIntegracion.commit();

        return true;
    }

    @Override
    public List<Usuario> listarUsuariosByTipo(Class<? extends Usuario> tipoUsuario) {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(tipoUsuario);
        List lista = null;

        integra.begin();
        lista = integra.listado();
        integra.commit();

        return lista;
    }
}
