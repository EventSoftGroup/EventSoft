<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Content Wrapper. Contains page content -->
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <%@ include file="../fragments/header.jspf" %>
        <c:if test="${rol eq 'Organizador'}">
            <%@ include file="../fragments/left-side-column-organizador.jspf" %>
        </c:if>
        <c:if test="${rol eq 'Proveedor'}">
            <%@ include file="../fragments/left-side-column-proveedor.jspf" %>
        </c:if>
        <c:if test="${rol eq 'Administrador'}">
            <%@ include file="../fragments/left-side-column-admin.jspf" %>
        </c:if>
        <c:if test="${rol eq 'Cliente'}">
            <%@ include file="../fragments/left-side-column-cliente.jspf" %>
        </c:if>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Calendario
                    <small>Panel de Control</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>Inicio</a></li>
                    <li class="active">Calendario</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
            <div class="row">
                <div class="col-md-3">
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h4 class="box-title">Eventos disponibles</h4>
                        </div>
                        <div class="box-body">
                            <!-- the events -->
                            <div id="external-events">
                                <div class="external-event bg-green">Catering</div>
                                <div class="external-event bg-yellow">Preparar recursos</div>
                                <div class="external-event bg-aqua">Limpiar utensilios</div>
                                <div class="external-event bg-light-blue">Viaje a Canarias</div>
                                <div class="external-event bg-red">Boda en Marugán</div>
                                <div class="checkbox">
                                    <label for="drop-remove">
                                        <input type="checkbox" id="drop-remove">
                                        Eliminar despues de colocar
                                    </label>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /. box -->
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Crear Evento</h3>
                        </div>
                        <div class="box-body">
                            <div class="btn-group" style="width: 100%; margin-bottom: 10px;">
                                <!--<button type="button" id="color-chooser-btn" class="btn btn-info btn-block dropdown-toggle" data-toggle="dropdown">Color <span class="caret"></span></button>-->
                                <ul class="fc-color-picker" id="color-chooser">
                                    <li><a class="text-aqua" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-blue" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-light-blue" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-teal" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-yellow" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-orange" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-green" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-lime" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-red" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-purple" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-fuchsia" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-muted" href="#"><i class="fa fa-square"></i></a></li>
                                    <li><a class="text-navy" href="#"><i class="fa fa-square"></i></a></li>
                                </ul>
                            </div>
                            <!-- /btn-group -->
                            <div class="input-group">
                                <input id="new-event" type="text" class="form-control" placeholder="Nombre del evento">

                                <div class="input-group-btn">
                                    <button id="add-new-event" type="button" class="btn btn-primary btn-flat">Añadir</button>
                                </div>
                                <!-- /btn-group -->
                            </div>
                            <!-- /input-group -->
                        </div>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-md-9">
                    <div class="box box-primary">
                        <div class="box-body no-padding">
                            <!-- THE CALENDAR -->
                            <div id="calendar"></div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /. box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        <!-- footer -->
        <%@ include file="../fragments/footer.jspf" %>
        <!-- control-sidebar -->
        <%@ include file="../fragments/control-sidebar.jspf" %>
        <!-- Add the sidebar's background. This div must be placed
        immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>

    </div>
    <!-- ./wrapper -->
    <%@ include file="../fragments/plugins.jspf" %>
    <!-- fullCalendar 2.2.5 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
    <script src="/plugins/fullcalendar/fullcalendar.min.js"></script>
    <!-- Page specific script -->
    <script>
        $(function () {

            /* initialize the external events
             -----------------------------------------------------------------*/
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

            /* initialize the calendar
             -----------------------------------------------------------------*/
            //Date for the calendar events (dummy data)
            var date = new Date();
            var d = date.getDate(),
                m = date.getMonth(),
                y = date.getFullYear();
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
                //Random default events
                events: [
                    {
                        title: 'Boda',
                        start: new Date(y, m, 1),
                        backgroundColor: "#f56954", //red
                        borderColor: "#f56954" //red
                    },
                    {
                        title: 'Preparar recursos',
                        start: new Date(y, m, d - 5),
                        end: new Date(y, m, d - 2),
                        backgroundColor: "#f39c12", //yellow
                        borderColor: "#f39c12" //yellow
                    },
                    {
                        title: 'Viaje',
                        start: new Date(y, m, d, 10, 30),
                        allDay: false,
                        backgroundColor: "#0073b7", //Blue
                        borderColor: "#0073b7" //Blue
                    },
                    {
                        title: 'Limpiar utensilios',
                        start: new Date(y, m, d, 12, 0),
                        end: new Date(y, m, d, 14, 0),
                        allDay: false,
                        backgroundColor: "#00c0ef", //Info (aqua)
                        borderColor: "#00c0ef" //Info (aqua)
                    },
                    {
                        title: 'Cumpleaños',
                        start: new Date(y, m, d + 1, 19, 0),
                        end: new Date(y, m, d + 1, 22, 30),
                        allDay: false,
                        backgroundColor: "#00a65a", //Success (green)
                        borderColor: "#00a65a" //Success (green)
                    },
                    {
                        title: 'Catering',
                        start: new Date(y, m, 28),
                        end: new Date(y, m, 29),
                        backgroundColor: "#3c8dbc", //Primary (light-blue)
                        borderColor: "#3c8dbc" //Primary (light-blue)
                    }
                ],
                editable: true,
                droppable: true, // this allows things to be dropped onto the calendar !!!
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

            /* ADDING EVENTS */
            var currColor = "#3c8dbc"; //Red by default
            //Color chooser button
            var colorChooser = $("#color-chooser-btn");
            $("#color-chooser > li > a").click(function (e) {
                e.preventDefault();
                //Save color
                currColor = $(this).css("color");
                //Add color effect to button
                $('#add-new-event').css({"background-color": currColor, "border-color": currColor});
            });
            $("#add-new-event").click(function (e) {
                e.preventDefault();
                //Get value and make sure it is not null
                var val = $("#new-event").val();
                if (val.length == 0) {
                    return;
                }

                //Create events
                var event = $("<div />");
                event.css({"background-color": currColor, "border-color": currColor, "color": "#fff"}).addClass("external-event");
                event.html(val);
                $('#external-events').prepend(event);

                //Add draggable funtionality
                ini_events(event);

                //Remove event from text input
                $("#new-event").val("");
            });
        });
    </script>
</body>
</html>