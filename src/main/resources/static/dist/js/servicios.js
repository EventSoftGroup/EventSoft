/**
 * Created by Tomas on 25/05/2017.
 */
$(function() {


    $(".botonEliminarServicio").on("click", function(e) {

        $.ajax({
            type : "POST",
            url : "/servicios/eliminar/" + $("#"+e.target.id).data("id"),

            success: function (response) {
                window.location.href = window.location.href;

                alert("Servicio eliminado correctamente.");
            },
            error: function(xhr, status, error) {

                debugger
                var err = eval("(" + xhr.responseText + ")");
                console.log(error);
                console.log(xhr);
                console.log(err.message);
                console.log(status);


                //alert(err.Message);


            }


        });

        return false;
    });
});