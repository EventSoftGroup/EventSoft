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

        console.log("Cambiando formulario...");

        if (valor === "Cliente") {
            client_panel();
            document.formulario_registro.action = "registrar_cliente.html";

        } else if (valor === "Organizador") {
            professional_panel();
            document.formulario_registro.action = "registrar_organizador.html";

        } else if (valor === "Proveedor") {
            professional_panel();
            document.formulario_registro.action = "registrar_proveedor.html";
        }

        console.log("nuevo form: " + document.formulario_registro.action);

    })
});