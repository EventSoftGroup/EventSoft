/**
 * Created by Tomás Muñoz Testón on 13/04/2017.
 */

$(function () {

    panel_bandeja_entrada();

    $('#botonBandejaEntrada').on('click', function(event){
        panel_bandeja_entrada();
        $('#botonBandejaEntrada').addClass("active");
        $('#botonBandejaEnviados').removeClass("active");
    })


    $('#botonBandejaEnviados').on('click', function(event){
        $('#botonBandejaEnviados').addClass("active");
        $('#botonBandejaEntrada').removeClass("active");

        panel_bandeja_enviados();
    })


    /* ============================
     - CONFIGURACIÓN DE PANELES
     ============================ */

    function panel_bandeja_entrada() {
        $('#bandeja_recibidos').show();
        $('#bandeja_enviados').hide();
    }

    function panel_bandeja_enviados() {
        $('#bandeja_enviados').show();
        $('#bandeja_recibidos').hide();
    }

    //==============================

});