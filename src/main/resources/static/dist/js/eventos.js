/**
 * Created by Tomas on 25/05/2017.
 */
$(function() {

    var combo_eventos = $("#eventos option:selected");
    var combo_categorias = $('#categorias opcion:selected');
    var div_evento = $('#box_sel_evento');
    var div_categoria = $('#box_sel_categoria');
    var texto_titulo_categoria = $('#titulo_categoria');

    var evento_seleccionado = undefined;
    var categoria_seleccionada = undefined;

    $('#aniadirServicio').on('click', function(e){
        e.preventDefault();

        evento_seleccionado = combo_eventos.text();

        texto_titulo_categoria.val("Seleccione la categoría para el evento - " + evento_seleccionado + " -");
        div_evento.fadeOut(function(){
            div_categoria.fadeIn();
        });

    })

    $('#buscarPorCategoria').on('click', function(e){
        e.preventDefault();

        categoria_seleccionada = combo_eventos.text();

        texto_titulo_categoria.val("Seleccione la categoría para el evento - " + evento_seleccionado + " -");
        div_categoria.fadeOut(function(){
            alert("Hasta aquí");
        });

    });

    $('#sel_evento_nuevo').on('click', function(e){
        e.preventDefault();

        div_categoria.fadeOut(function(){
            div_evento.fadeIn();
        });

    });
});