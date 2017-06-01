/**
 * Created by Tomas on 25/05/2017.
 */
$(function() {

    var demo1 = $('select[name="mi_duallist[]"]').bootstrapDualListbox();
    var combo_eventos = $("#eventos option:selected");
    var combo_categorias = $('#categorias option:selected');
    var div_evento = $('#box_sel_evento');
    var div_categoria = $('#box_sel_categoria');
    var div_sel_eventos = $('#box_sel_categoria_2');
    var div_mostrar_eventos = $('#box_mostrar_eventos');
    var texto_titulo_categoria = $('#titulo_categoria');
    var texto_titulo_sel_eventos = $('#titulo_categoria_2');
    var boton_mostrarEventos = $('#mostrarEventosTodos');
    var boton_ocultarEventos= $('#ocultarEventos');
    var panel_todos_eventos = $('#panelTodosLosEventos');
    var panel_evento = $('#panelUnEvento');
    var cargando = $('#cargando');
    var tabla_eventos = $('#tabla_eventos tbody');

    var evento_seleccionado = undefined;
    var categoria_seleccionada = undefined;

    div_mostrar_eventos.hide();
    boton_ocultarEventos.hide();
    panel_todos_eventos.hide();
    cargando.hide();
    panel_evento.hide();


    $('#aniadirServicio').on('click', function(e){
        e.preventDefault();

        evento_seleccionado = combo_eventos.text();
        console.log($("#eventos option:selected").text());
        console.log($("#eventos option:selected").val());



        texto_titulo_categoria.text("Seleccione la categoría para el evento - " + $("#eventos option:selected").text() + " -");
        div_evento.fadeOut(function(){
            div_categoria.fadeIn();
        });

    })

    $('.content').on('click', '#buscarPorCategoria', function(e){
        e.preventDefault();

        categoria_seleccionada = combo_categorias.text();

        texto_titulo_sel_eventos.text("Seleccione los eventos de la categoria - " + $('#categorias option:selected').text() + " -");


        console.log("/servicios/buscarServiciosByTipoServicio/" + $('#categorias option:selected').text())
        $.ajax({
            type : "GET",
            url : "/servicios/buscarServiciosByTipoServicio/" + $('#categorias option:selected').text(),

            success : function(response) {

                response.forEach(function(element) {
                    $('#selectServicios').append($('<option>', {
                        value: element.id,
                        text: element.nombre +"  --  " + element.descripcion.substring(0, 55)
                    }));
                });

                div_categoria.fadeOut(function(){
                    div_sel_eventos.fadeIn();
                    demo1.bootstrapDualListbox('refresh');
                });
            },

            error : function(e) {
                alert("Ocurrió un error al cargar esa categoria");
                //alert('Error: ' + e);
            }
        });


    });

    $('#sel_evento_nuevo').on('click', function(e){
        e.preventDefault();

        div_categoria.fadeOut(function(){
            div_evento.fadeIn();
        });
    });

    $('#cambiar_evento').on('click', function(e){
        e.preventDefault();

        div_sel_eventos.fadeOut(function(){
            div_categoria.fadeOut(function(){
                div_evento.fadeIn();
            });
        });
    });

    $('#cambiar_categoria').on('click', function(e){
        e.preventDefault();
        div_sel_eventos.fadeOut(function(){
            div_categoria.fadeIn();
        });
    });

    $("#guardar_eventos").on("click", function(e) {
        e.preventDefault();

        listaIDsServicios = [];
        $('[name="mi_duallist[]"]').val().forEach(function (id) {
            listaIDsServicios.push(Number(id));
        })

        console.log("/eventos/añadirServiciosAEvento/" + $("#eventos option:selected").val());
        $.ajax({
            type : "POST",
            url : "/eventos/añadirServiciosAEvento/" + $("#eventos option:selected").val(),
            data: {
                servicios: listaIDsServicios
            },
            success: function () {
                window.location.href = window.location.href;
            },
            error: function () {
                window.location.href = window.location.href;
            }


        });

        return false;
    });


    $("#eventos").on("change", function(e) {
        e.preventDefault();
        buscarEvento($("#eventos option:selected").val());
    });



    $("#mostrarEventosTodos").on("click", function(e) {
        e.preventDefault();
        buscarTodosLosEventos(false);

    });
    var buscarEvento = function(idEvento) {
        boton_mostrarEventos.show();
        boton_ocultarEventos.hide();
        cargando.show();
        panel_todos_eventos.fadeOut();
        $.ajax({
            type : "GET",
            url : "/eventos/buscarEvento/"+idEvento,
            success : function(response) {

                panel_todos_eventos.fadeOut(function(){
                    boton_mostrarEventos.show();
                    boton_ocultarEventos.hide();
                    panel_evento.fadeIn();
                    cargando.hide();
                });

                var dini = undefined;
                var dfin = undefined;


                //Cargamos el evento
                dini = new Date(response.fechaInicio);
                dfin = new Date(response.fechaFin);
                $("#tabla_evento tbody").empty();
                $("#tabla_evento tbody").append("<tr></tr>");
                $("#tabla_evento tbody tr:last-child").append("<td class='mailbox-subject text-center'>"+response.nombre+"</td>");
                $("#tabla_evento tbody tr:last-child").append("<td class='mailbox-subject text-center'>"+response.categoria+"</td>");
                $("#tabla_evento tbody tr:last-child").append("<td class='mailbox-subject text-center'>"+response.descripcion.substring(1,70)+"</td>");
                $("#tabla_evento tbody tr:last-child").append("<td class='mailbox-subject text-center'>"+response.lugar+"</td>");
                $("#tabla_evento tbody tr:last-child").append("<td class='mailbox-date text-center'>"+dini.getDate() + '-' + dini.getMonth() + '-' + dini.getFullYear()+"</td>");
                $("#tabla_evento tbody tr:last-child").append("<td class='mailbox-date text-center'>"+dfin.getDate() + '-' + dfin.getMonth() + '-' + dfin.getFullYear()+"</td>");
                $("#tabla_evento tbody tr:last-child").append("<td class='mailbox-subject'><a type='button' class='btn btn-default text-center botonEliminarServicio' id='' data-id=''><i class='fa fa-trash-o'></i>Eliminar</a></td>");


            },
            error: function () {
                cargando.hide();
                alert("Error");
            }
        });
    };

    var buscarTodosLosEventos = function(ini) {
        cargando.show();
        $.ajax({
            type : "GET",
            url : "/eventos/buscarEventosByUser/",
            success : function(response) {

                //Caso del botón
                if (!ini) {

                    var dini = undefined;
                    var dfin = undefined;


                    //Cargamos los eventos
                    $("#tabla_eventos tbody").empty();
                    response.forEach(function(e){
                        dini = new Date(e.fechaInicio);
                        dfin = new Date(e.fechaFin);
                        $("#tabla_eventos tbody").append("<tr></tr>");
                        $("#tabla_eventos tbody tr:last-child").append("<td><a href='/eventos/buscarEvento/' type='button' class='btn btn-default text-center'><i class='fa fa-search'></i> Ver</a></td>");
                        $("#tabla_eventos tbody tr:last-child").append("<td class='mailbox-subject text-center'>"+e.nombre+"</td>");
                        $("#tabla_eventos tbody tr:last-child").append("<td class='mailbox-subject text-center'>"+e.categoria+"</td>");
                        $("#tabla_eventos tbody tr:last-child").append("<td class='mailbox-subject text-center'>"+e.descripcion.substring(1,70)+"</td>");
                        $("#tabla_eventos tbody tr:last-child").append("<td class='mailbox-subject text-center'>"+e.lugar+"</td>");
                        $("#tabla_eventos tbody tr:last-child").append("<td class='mailbox-date text-center'>"+dini.getDate() + '-' + dini.getMonth() + '-' + dini.getFullYear()+"</td>");
                        $("#tabla_eventos tbody tr:last-child").append("<td class='mailbox-date text-center'>"+dfin.getDate() + '-' + dfin.getMonth() + '-' + dfin.getFullYear()+"</td>");
                        $("#tabla_eventos tbody tr:last-child").append("<td class='mailbox-subject'><a type='button' class='btn btn-default text-center botonEliminarServicio' id='' data-id=''><i class='fa fa-trash-o'></i>Eliminar</a></td>");
                    });


                    panel_evento.fadeOut(function(){
                        boton_mostrarEventos.hide();
                        boton_ocultarEventos.show();
                        panel_todos_eventos.fadeIn();
                        cargando.hide();
                    });
                }
                else {
                    //Cargamos los eventos

                    cargando.hide();
                    $('#eventos').empty();
                    response.forEach(function(e){
                        $('#eventos').append("<option value='"+e.id+"'>"+e.nombre+"</option>");
                    });
                    buscarEvento($("#eventos option:selected").val());
                }

            },
            error: function () {
                cargando.hide();
                var err = eval("(" + xhr.responseText + ")");
                console.log(error);
                console.log(xhr);
                console.log(err.message);
                console.log(status);
            }
        });
    }

    $("#ocultarEventos").on("click", function(e) {
        e.preventDefault();

        boton_mostrarEventos.show();
        boton_ocultarEventos.hide();
        panel_todos_eventos.hide();
        buscarEvento($("#eventos option:selected").val());
    });

    //EVENTOS INICIALES.
    buscarTodosLosEventos(true);
});