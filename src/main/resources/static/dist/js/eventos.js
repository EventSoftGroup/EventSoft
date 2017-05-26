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
    var texto_titulo_categoria = $('#titulo_categoria');
    var texto_titulo_sel_eventos = $('#titulo_categoria_2');

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

        categoria_seleccionada = combo_categorias.text();
        texto_titulo_sel_eventos.text("Seleccione los eventos de la categoria - " + categoria_seleccionada + " -");
        div_categoria.fadeOut(function(){
            div_sel_eventos.fadeIn();
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
        alert($('[name="mi_duallist[]"]').val());
        return false;
    });
});