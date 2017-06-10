/**
 * Created by Tomas on 25/05/2017.
 */
$(function() {


    function event(title, start, end) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.backgroundColor = "#f56954"; //red
        this.borderColor = "#f56954" //red
    }

    var buscarTodosLosEventos = function(ini) {

        $.ajax({
            type : "GET",
            url : "/eventos/buscar/por-usuario/",
            success : function(response) {

                var date;
                var diaInicio = "",
                    mesInicio = "",
                    anioInicio = "",
                    diaFin = "",
                    mesFin = "",
                    anioFin = ""
                var events = [];

                response.forEach(function(e){

                    date = new Date(e.fechaFin);

                    events.push(new event(e.nombre,
                                        e.fechaInicio,
                                        date.setDate(date.getDate() + 1)));
                });

                function ini_events(ele) {
                    ele.each(function () {

                        // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
                        // it doesn't need to have a start or end
                        var eventObject = {
                            title: $.trim($(this).text()) // use the element's text as the event title
                        };

                        // store the Event Object in the DOM element so we can get to it later
                        $(this).data('eventObject', eventObject);

                        // make the event draggable using jQuery UI
                        $(this).draggable({
                            zIndex: 1070,
                            revert: true, // will cause the event to go back to its
                            revertDuration: 0  //  original position after the drag
                        });

                    });
                }

                ini_events($('#external-events div.external-event'));

                $('#calendar').fullCalendar({
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,agendaWeek,agendaDay'
                    },
                    buttonText: {
                        today: 'Hoy',
                        month: 'mes',
                        week: 'semana',
                        day: 'dia'
                    },
                    //Valores de los eventos cargados
                    events: events,
                    editable: false,
                    droppable: false, // this allows things to be dropped onto the calendar !!!
                    drop: function (date, allDay) { // this function is called when something is dropped

                        // retrieve the dropped element's stored Event Object
                        var originalEventObject = $(this).data('eventObject');

                        // we need to copy it, so that multiple events don't have a reference to the same object
                        var copiedEventObject = $.extend({}, originalEventObject);

                        // assign it the date that was reported
                        copiedEventObject.start = date;
                        copiedEventObject.allDay = allDay;
                        copiedEventObject.backgroundColor = $(this).css("background-color");
                        copiedEventObject.borderColor = $(this).css("border-color");

                        // render the event on the calendar
                        // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
                        $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

                        // is the "remove after drop" checkbox checked?
                        if ($('#drop-remove').is(':checked')) {
                            // if so, remove the element from the "Draggable Events" list
                            $(this).remove();
                        }

                    }
                });


            },
            error: function () {
                var err = eval("(" + xhr.responseText + ")");
                console.log(error);
                console.log(xhr);
                console.log(err.message);
                console.log(status);
            }
        });
    }

    //EVENTOS INICIALES.
    buscarTodosLosEventos(true);
});