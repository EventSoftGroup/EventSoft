package es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.Imp;


import com.sun.org.apache.bcel.internal.generic.SASTORE;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.operations.Bool;
import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Evento;
import es.fdi.eventsoft.Negocio.Entidades.EventoServicio;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Eventos.SAEventos;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Servicios.SAServicios;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;
import javafx.util.Pair;

import javax.swing.event.ListDataEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.*;

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
    public EventosNegocio añadirServiciosAEvento(Long idEvento, List<Long> servicios){
        FachadaIntegracion integra;
        SAServicios saServicios;
        Servicio serv;
        List<EventoServicio> listaES;
        EventosNegocio result = null;
        boolean todoOk = true;

        if(idEvento<=0) {
            result = ERROR_BUSCAR_EVENTO;
            todoOk &= false;

        }else{
            integra = FachadaIntegracion.newInstance(Evento.class);
            integra.begin();
            Evento evento = (Evento) integra.consulta(idEvento);

            if(evento== null){
                result = ERROR_BUSCAR_EVENTO;
                todoOk &= false;

            }else{
                if(servicios.isEmpty()){
                    integra.commit();
                    result = LISTA_SERVICIOS_VACIA;
                    todoOk &= false;
                }else {
                    saServicios = FactoriaSA.getInstance().crearSAServicios();
                    listaES = new ArrayList<>();
                    for (Long id : servicios) {

                        serv = saServicios.buscarServicio(id);

                        if (serv == null) {
                            todoOk &= false;
                            result = NO_SE_PUDO_AÑADIR_ALGUN_EVENTO;

                        } else {//correcto todo
                            EventoServicio eventServ = new EventoServicio(evento, serv);
                            if(!evento.getEventoServicios().contains(eventServ))
                                listaES.add(eventServ);
                            todoOk &= true;

                        }
                    }

                    evento.addEventoServicios(listaES);
                    if(integra.modifica(evento)){
                        integra.commit();
                        todoOk &= true;
                    }else{
                        todoOk &= false;
                        result = EventosNegocio.ERROR_AÑADIR_SERVICIOS_A_EVENTO;
                    }

                }
            }
        }


        return (todoOk)? AÑADIR_SERVICIOS_A_EVENTO: result;
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
    public List<Evento> buscarEventosByUsuario(Usuario usuario) {
        List<Evento> lista = null;
        FachadaIntegracion integra;
        Usuario finalUsuario = usuario;

        if(usuario == null) return null;

        try {

            if (usuario.getEmail() != null) finalUsuario = (Usuario) FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByEmail(usuario.getEmail());
            else if (usuario.getId() != null) finalUsuario = (Usuario) FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByID(usuario.getId());
            else return lista;


            if(finalUsuario == null) return null;
            if (finalUsuario instanceof Cliente) {
                try{
                    Cliente cliente = (Cliente) finalUsuario;
                    integra = FachadaIntegracion.newInstance(Evento.class);
                    integra.begin();
                    lista = integra.ejecutarNamedQuery("Evento.buscarEventosPorUsuario", Arrays.asList(new Pair<>("cliente", cliente)));
                    integra.commit();
                    return lista;

                } catch (Exception e){
                    return null;
                }
            }
            else if (finalUsuario instanceof Organizador) {
                try{
                    Organizador organizador = (Organizador) finalUsuario;
                    integra = FachadaIntegracion.newInstance(Evento.class);
                    integra.begin();
                    lista = integra.ejecutarNamedQuery("Evento.buscarEventosPorUsuario_2", Arrays.asList(new Pair<>("organizador", organizador)));
                    integra.commit();
                    return lista;

                } catch (Exception e){
                    return null;
                }
            }
            else
                System.out.println("No eres nadie");

        }catch (ClassCastException e){
            return null;
        }

        return lista;
    }
}
