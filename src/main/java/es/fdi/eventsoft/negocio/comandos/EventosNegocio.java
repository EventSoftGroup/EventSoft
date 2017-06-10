package es.fdi.eventsoft.negocio.comandos;

public enum EventosNegocio {
    //******** EVENTOS NEGOCIO USUARIOS ************
    CREAR_USUARIO,
    USUARIO_CREADO,
    ERROR_CREAR_USUARIO,

    BUSCAR_USUARIO_BY_ID,
    BUSCAR_USUARIO_BY_EMAIL,
    ERROR_BUSCAR_USUARIO,

    ELIMINAR_USUARIO,
    ERROR_ELIMINAR_USUARIO,

    MODIFICAR_USUARIO,
    ERROR_MODIFICAR_USUARIO,

    EMAIL_YA_EXISTENTE,

    ERROR_LISTAR_USUARIOS,
    LISTAR_USUARIOS,


    //******** EVENTOS NEGOCIO VALORACIONES ************


    CREAR_VALORACION,
    ERROR_CREAR_VALORACION,

    BUSCAR_VALORACION,
    ERROR_BUSCAR_VALORACION,

    ELIMINAR_VALORACION,
    ERROR_ELIMINAR_VALORACION,

    BUSCAR_VALORACION_BY_USUARIO,



    //******** EVENTOS NEGOCIO MENSAJES ************


    CREAR_MENSAJE,
    ERROR_CREAR_MENSAJE,

    BUSCAR_MENSAJE,
    ERROR_BUSCAR_MENSAJE,

    ELIMINAR_MENSAJE,
    ERROR_ELIMINAR_MENSAJE,

    BUSCAR_MENSAJES_BY_USER,
    NO_lISTA_MENSAJES,




    //******** EVENTOS NEGOCIO SERVICIOS ************

    CREAR_SERVICIO,
    ERROR_CREAR_SERVICIO,

    BUSCAR_SERVICIO,
    ERROR_BUSCAR_SERVICIO,

    MODIFICAR_SERVICIO,
    ERROR_MODIFICAR_SERVICIO,

    ELIMINAR_SERVICIO,
    ERROR_ELIMINAR_SERVICIO,
    ERROR_SERVICIO_ASOCIADO_A_EVENTO,

    BUSCAR_SERVICIOS_BY_PROVEEDOR,
    BUSCAR_SERVICIOS_BY_EVENTO,
    BUSCAR_SERVICIOS_BY_TIPO_SERVICIO,
    BUSCAR_SERVICIOS_ENTRE_FECHAS,

    ERROR_BUSCAR_SERVICIOS,




    //******** EVENTOS NEGOCIO EVENTOS ************



    CREAR_EVENTO,
    ERROR_CREAR_EVENTO,

    BUSCAR_EVENTO,
    ERROR_BUSCAR_EVENTO,

    MODIFICAR_EVENTO,
    ERROR_MODIFICAR_EVENTO,

    ELIMINAR_EVENTO,
    ERROR_ELIMINAR_EVENTO,

    BUSCAR_EVENTOS_BY_USUARIO,
    BUSCAR_EVENTOS_BY_USUARIO_ERROR,

    ANADIR_SERVICIOS_A_EVENTO,
    NO_SE_PUDO_AÑADIR_ALGUN_EVENTO,
    LISTA_SERVICIOS_VACIA,
    ERROR_AÑADIR_SERVICIOS_A_EVENTO,
    LISTAR_SERVICIOS,

    LISTAR_EVENTOS,
    COUNT_MENSAJES,
    ERROR_CLIENTE_ERRONEO,
    ERROR_ORGANIZADOR_ERRONEO, SERVICIO_CON_FECHAS_OCUPADAS;
}