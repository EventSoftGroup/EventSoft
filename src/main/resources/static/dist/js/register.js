/**
 * Created by Tomás Muñoz Testón on 13/04/2017.
 */

$(function () {

    /* ============================
     - CONFIGURACIÓN DE PANELES
     ============================ */

    function professional_panel() {
        $('#form_profesional').show();
        //$('#form_cliente').hide();
        $('#form_especifico').detach("div");
        $('#form_especifico').append(
            '<!-- Nombre empresa -->' +
            '<div class="form-group has-feedback">' +
            '    <input id="empresa" type="text" class="form-control" placeholder="Nombre empresa" name="empresa">' +
            '    <springForm:input path="empresa" />' +
            '    <span class="glyphicon glyphicon-briefcase form-control-feedback"></span>' +
            '</div>' +
            '<!-- CIF -->' +
            '<div class="form-group has-feedback">' +
            '   <input type="text" class="form-control" placeholder="CIF" name="cif">' +
            '   <springForm:input path="cif" />' +
            '   <span class="glyphicon glyphicon-list-alt form-control-feedback"></span>' +
            '</div>'
        );

        $('#empresa').focus();
    }

    function client_panel() {
        $('#form_cliente').show();
        //$('#form_profesional').hide();
        $('#form_especifico').detach("div");
        $('#form_especifico').append(
            "<!-- Nombre -->" +
            '<div class="form-group has-feedback">' +
            '   <input id="nombre" type="text" class="form-control" placeholder="Nombre" name="nombre" autofocus/>' +
            '   <springForm:input path="nombre" class="form-control"  />' +
            '   <span class="glyphicon glyphicon-user form-control-feedback"></span>' +
            '</div>' +
            '<!-- Apellidos -->' +
            ' <div class="form-group has-feedback">' +
            '   <input type="text" class="form-control" placeholder="Apellidos" name="apellidos">' +
            '   <springForm:input path="apellidos" />' +
            '   <span class="glyphicon glyphicon-user form-control-feedback"></span>' +
            '</div>'
        );
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
            action = "registrar_cliente.html";
            modelAttribute = "clienteNuevo";

        } else if (valor === "Organizador") {
            professional_panel();
            action = "registrar_organizador.html";
            modelAttribute = "organizadorNuevo";

        } else if (valor === "Proveedor") {
            professional_panel();
            action = "registrar_proveedor.html";
            modelAttribute = "proveedorNuevo";
        }

        document.formulario_registro.action = action;
        document.formulario_registro.modelAttribute = modelAttribute;

        console.log("nuevo form: " + document.formulario_registro.action);

    })
});