package es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.Imp;

import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Eventos.*;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Mensajes.*;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Servicios.*;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Usuarios.*;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Valoraciones.ComandoBuscarValoracion;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Valoraciones.ComandoBuscarValoracionesByUser;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Valoraciones.ComandoCrearValoracion;
import es.fdi.eventsoft.Negocio.Comandos.Imp.Comandos_Valoraciones.ComandoEliminarValoracion;

/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
public class FactoriaComandosImp extends FactoriaComandos {

    public Comando crearComando(EventosNegocio tipoComando) {
        Comando miComando = null;

        switch (tipoComando) {

            //***************************************************//
            //**************** Comandos Usuarios ****************//
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





            //***************************************************//
            //**************** Comandos Valoraciones ************//
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
            //**************** Comandos MENSAJES ****************//
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

            case BUSCAR_MENSAJES_BY_USER_EMISOR:
                miComando = new ComandoBuscarMensajesByUser_Emisor();
                break;

            case BUSCAR_MENSAJES_BY_USER_RECEPTOR:
                miComando = new ComandoBuscarMensajesByUser_Receptor();
                break;



            //***************************************************//
            //**************** Comandos SERVICIOS ***************//
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

            case BUSCAR_SERVICIOS_BY_EVENTO:
                miComando = new ComandoBuscarServiciosByEvento();
                break;

            case BUSCAR_SERVICIOS_ENTRE_FECHAS:
                miComando = new ComandoBuscarServiciosEntreFechas();
                break;





            //***************************************************//
            //**************** Comandos EVENTOS *****************//
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

        }

        return miComando;
    }

}
