package es.fdi.eventsoft.negocio.servicios.eventos.imp;


import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.entidades.Evento;
import es.fdi.eventsoft.negocio.entidades.EventoServicio;
import es.fdi.eventsoft.negocio.entidades.Mensaje;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Organizador;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import es.fdi.eventsoft.negocio.servicios.eventos.SAEventos;
import es.fdi.eventsoft.negocio.servicios.servicios.SAServicios;
import es.fdi.eventsoft.negocio.servicios.usuarios.SAUsuario;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;

public class SAEventosImp implements SAEventos {

    @Override
    public Long crearEvento(Evento eventoNuevo) {

        FachadaIntegracion integra;
        Long id = -1L;
        SAUsuario saUsuario;
        Cliente cliente = null;
        Organizador organizador = null;


        if (eventoNuevo.getOrganizador() == null) id = -3L;
        else if (eventoNuevo.getCliente() == null) id = -2L;
        else{
            saUsuario  = FactoriaSA.getInstance().crearSAUsuarios();

            try {
                cliente = (Cliente) saUsuario.buscarUsuarioByEmail(eventoNuevo.getCliente().getEmail());
            }catch (ClassCastException e ){ return -2L;}

            try {
                organizador = (Organizador) saUsuario.buscarUsuarioByID(eventoNuevo.getOrganizador().getId());
            }catch (ClassCastException e ){ return -3L; }


            if (organizador == null) id = -3L;
            else if (cliente == null) id = -2L;
            else {
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
        //evento.getCliente();
        //evento.getOrganizador();
        //evento.getEventoServicios();
        fachadaIntegracion.commit();
        evento.setCliente(null);
        evento.setOrganizador(null);
        evento.setEventoServicios(null);

        return evento;
    }
    @Override
    public Evento buscarEventoParaModificar(Long id) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Evento.class);

        fachadaIntegracion.begin();
        Evento evento = (Evento) fachadaIntegracion.consulta(id);
        fachadaIntegracion.commit();

        return evento;
    }

    @Override
    public boolean eliminarEvento(Long id) {
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Evento.class);

        boolean respuesta;

        fachadaIntegracion.begin();
        respuesta = fachadaIntegracion.baja(id);
        fachadaIntegracion.commit();

        return respuesta;
    }

    @Override
    public boolean modificarEvento(Evento eventoModificado){
        FachadaIntegracion fachadaIntegracion = FachadaIntegracion.newInstance(Evento.class);
        boolean ok = true;

        fachadaIntegracion.begin();
        ok = fachadaIntegracion.modifica(eventoModificado);
        fachadaIntegracion.commit();

        return ok;
    }

    @Override
    public List<Evento> buscarEventosByUsuario(Usuario usuario) {
        List<Evento> lista = new ArrayList<Evento>();
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
                    //El siguiente for es una guarreria de codigo, pero la carga LAZY no funciona bien y la EAGER genera buble infinito
                    for(Evento ev: lista) {
                        ev.setOrganizador(null);
                        ev.setCliente(null);
                        ev.setEventoServicios(null);
                    }
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
                    //El siguiente for es una guarreria de codigo, pero la carga LAZY no funciona bien y la EAGER genera buble infinito
                    for(Evento ev: lista) {
                        ev.setOrganizador(null);
                        ev.setCliente(null);
                        ev.setEventoServicios(null);
                    }
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

    @Override
    public List<Evento> listarEventos() {
        FachadaIntegracion integra = FachadaIntegracion.newInstance(Evento.class);
        List<Evento> lista;

        integra.begin();
        lista = integra.listado();

        lista.stream().forEach(e -> {
            e.getCliente().getEmail();
            e.getOrganizador().getEmail();
            e.setEventoServicios(null);
        });

        integra.commit();


        return lista;
    }
}
