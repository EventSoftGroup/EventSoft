package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.Imp;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.SAEventos;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;
import javafx.util.Pair;

import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.BUSCAR_MENSAJES_BY_USER;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public class SAEventosImp implements SAEventos {


    @Override
    public Long crearEvento(Evento eventoNuevo) {

        FachadaIntegracion integra;
        Long id = -1L;
        SAUsuario saUsuario = FactoriaSA.getInstance().crearSAUsuarios();

        Cliente cliente = (Cliente) saUsuario.buscarUsuarioByEmail(eventoNuevo.getCliente().getEmail());
        Organizador organizador = (Organizador) saUsuario.buscarUsuarioByID(eventoNuevo.getOrganizador().getId());

        if(organizador != null){
            if(cliente != null){
                eventoNuevo.setCliente(cliente);
                eventoNuevo.setOrganizador(organizador);

                integra = FachadaIntegracion.newInstance(Evento.class);
                integra.begin();
                id = ((Evento) integra.alta(eventoNuevo)).getId();

                integra.commit();
            }
        }

        return id;
    }

    @Override
    public Evento buscarEvento(Long id) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Evento.class);

        fachadaIntegracion.begin();
        Evento evento = (Evento) fachadaIntegracion.consulta(id);
        fachadaIntegracion.commit();

        return evento;
    }

    @Override
    public int eliminarEvento(Evento evento) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public int modificarEvento(Evento eventoModificado) throws ExcepcionNegocio {
        //TODO
        return 0;
    }

    @Override
    public List<Evento> buscarEventosByUsuario(Usuario usuario) throws ExcepcionNegocio {
        //TODO
        return null;
    }
}
