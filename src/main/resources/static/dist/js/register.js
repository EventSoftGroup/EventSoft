/**
 * Created by Tomás Muñoz Testón on 13/04/2017.
 */

$(function () {

    /* ============================
     - CONFIGURACIÓN DE PANELES
     ============================ */

    function professional_panel() {
        $('#form_profesional').show();
        $('#form_cliente').hide();
        $('#empresa').focus();
    }

    function client_panel() {
        $('#form_cliente').show();
        $('#form_profesional').hide();
        $('#nombre').focus();
    }

    //==============================
    client_panel();

    $('#rol').on('change', function(event){
        event.preventDefault();
        var valor = $(this).val();
        if (valor === "Cliente") {
            client_panel();
        } else {
            professional_panel();
        }
    })
});