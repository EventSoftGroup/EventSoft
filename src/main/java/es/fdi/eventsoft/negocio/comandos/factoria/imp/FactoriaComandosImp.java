package es.fdi.eventsoft.negocio.comandos.factoria.imp;

import es.fdi.eventsoft.negocio.comandos.Comando;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.comandos.imp.mensajes.*;
import es.fdi.eventsoft.negocio.comandos.imp.usuarios.ComandoListarUsuarios;
import es.fdi.eventsoft.negocio.comandos.imp.eventos.*;
import es.fdi.eventsoft.negocio.comandos.imp.servicios.*;
import es.fdi.eventsoft.negocio.comandos.imp.usuarios.*;
import es.fdi.eventsoft.negocio.comandos.imp.valoraciones.ComandoBuscarValoracion;
import es.fdi.eventsoft.negocio.comandos.imp.valoraciones.ComandoBuscarValoracionesByUser;
import es.fdi.eventsoft.negocio.comandos.imp.valoraciones.ComandoCrearValoracion;
import es.fdi.eventsoft.negocio.comandos.imp.valoraciones.ComandoEliminarValoracion;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class FactoriaComandosImp extends FactoriaComandos {

    public Comando crearComando(EventosNegocio tipoComando) {
        Comando miComando = null;

        switch (tipoComando) {

            //***************************************************//
            //**************** comandos Usuarios ****************//
            //***************************************************//

            case CREAR_USUARIO:
                miComando = new ComandoCrearUsuario();
                break;


            case BUSCAR_USUARIO_BY_ID:
                miComando = new ComandoBuscarUsuarioByID();
                break;

            case BUSCAR_USUARIO_BY_EMAIL:
                miComando = new ComandoBuscarUsuarioByEmail();
                break;

            case ELIMINAR_USUARIO:
                miComando = new ComandoEliminarUsuario();
                break;

            case MODIFICAR_USUARIO:
                miComando = new ComandoModificarUsuario();
                break;

            case LISTAR_USUARIOS:
                miComando = new ComandoListarUsuarios();
                break;



            //***************************************************//
            //**************** comandos Valoraciones ************//
            //***************************************************//

            case CREAR_VALORACION:
                miComando = new ComandoCrearValoracion();
                break;

            case BUSCAR_VALORACION:
                miComando = new ComandoBuscarValoracion();
                break;
            case ELIMINAR_VALORACION:
                miComando = new ComandoEliminarValoracion();
                break;

            case BUSCAR_VALORACION_BY_USUARIO:
                miComando = new ComandoBuscarValoracionesByUser();
                break;






            //***************************************************//
            //**************** comandos MENSAJES ****************//
            //***************************************************//

            case CREAR_MENSAJE:
                miComando = new ComandoCrearMensaje();
                break;


            case BUSCAR_MENSAJE:
                miComando = new ComandoBuscarMensaje();
                break;


            case ELIMINAR_MENSAJE:
                miComando = new ComandoEliminarMensaje();
                break;

            case BUSCAR_MENSAJES_BY_USER:
                miComando = new ComandoBuscarMensajesByUser();
                break;

            case COUNT_MENSAJES:
                miComando = new ComandoCountMensajes();
                break;




            //***************************************************//
            //**************** comandos SERVICIOS ***************//
            //***************************************************//


            case CREAR_SERVICIO:
                miComando = new ComandoCrearServicio();
                break;

            case BUSCAR_SERVICIO:
                miComando = new ComandoBuscarServicio();
                break;

            case MODIFICAR_SERVICIO:
                miComando = new ComandoModificarServicio();
                break;

            case ELIMINAR_SERVICIO:
                miComando = new ComandoEliminarServicio();
                break;

            case BUSCAR_SERVICIOS_BY_PROVEEDOR:
                miComando = new ComandoBuscarServiciosByProveedor();
                break;

            case BUSCAR_SERVICIOS_BY_TIPO_SERVICIO:
                miComando = new ComandoBuscarServiciosByTipoServicio();
                break;

            case BUSCAR_SERVICIOS_BY_EVENTO:
                miComando = new ComandoBuscarServiciosByEvento();
                break;

            case BUSCAR_SERVICIOS_ENTRE_FECHAS:
                miComando = new ComandoBuscarServiciosEntreFechas();
                break;

            case LISTAR_SERVICIOS:
                miComando = new ComandoListarServicios();
                break;





            //***************************************************//
            //**************** comandos EVENTOS *****************//
            //***************************************************//

            case CREAR_EVENTO:
                miComando = new ComandoCrearEvento();
                break;

            case BUSCAR_EVENTO:
                miComando = new ComandoBuscarEvento();
                break;
            case MODIFICAR_EVENTO:
                miComando = new ComandoModificarEvento();
                break;

            case ELIMINAR_EVENTO:
                miComando = new ComandoEliminarEvento();
                break;


            case BUSCAR_EVENTOS_BY_USUARIO:
                miComando = new ComandoBuscarEventosByUser();
                break;

            case AÑADIR_SERVICIOS_A_EVENTO:
                miComando = new ComandoAnadirServiciosAEvento();
                break;

            case LISTAR_EVENTOS:
                miComando = new ComandoListarEventos();
                break;

        }

        return miComando;
    }

}
