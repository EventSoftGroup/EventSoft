<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Content Wrapper. Contains page content -->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@ include file="../fragments/header.jspf" %>
    <%@ include file="../fragments/left-side-column.jspf" %>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Notificaciones
                <small>5 notificaciones nuevas</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Inicio</a></li>
                <li class="active">Notificaciones</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Mis Notificaciones</h3>

                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <input type="text" class="form-control input-sm" placeholder="Buscar notificación">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </div>
                            <!-- /.box-tools -->
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                                </button>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                </div>
                                <!-- /.btn-group -->
                                <button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                <div class="pull-right">
                                    1-50/200
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                        <button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                    </div>
                                    <!-- /.btn-group -->
                                </div>
                                <!-- /.pull-right -->
                            </div>
                            <div class="table-responsive mailbox-messages">
                                <table class="table table-hover table-striped">
                                    <tbody>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="/eventos/leer-notificacion"><b>Cancelación del evento</b> </a></td>
                                        <td class="mailbox-subject"><b>Boda en Marugán</b> - Por diversos motivos...
                                        </td>
                                        <td class="mailbox-attachment"></td>
                                        <td class="mailbox-date">hace 5 mins</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="/eventos/leer-notificacion"><b>Completada la compra de mmpp</b></a></td>
                                        <td class="mailbox-subject"><b>Mi servicio</b> - Hemos comprado los siguientes materiales...
                                        </td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">hace 28 mins</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="/eventos/leer-notificacion">Recordatorio</a></td>
                                        <td class="mailbox-subject"><b>Evento Tordesillas</b> - Se acerca el evento...
                                        </td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">hace 11 horas</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="/eventos/leer-notificacion">Confirmación de pago</a></td>
                                        <td class="mailbox-subject"><b>Juan Manuel Cubero</b> - Confirmar cuenta para abonar...
                                        </td>
                                        <td class="mailbox-attachment"></td>
                                        <td class="mailbox-date">hace 15 horas</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-name"><a href="/eventos/leer-notificacion">Solicitud de evento</a></td>
                                        <td class="mailbox-subject"><b>Evento UCM</b> - Se le solicita para...
                                        </td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">Ayer</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <!-- /.table -->
                            </div>
                            <!-- /.mail-box-messages -->
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                                </button>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                </div>
                                <!-- /.btn-group -->
                                <button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                <div class="pull-right">
                                    1-50/200
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                        <button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                    </div>
                                    <!-- /.btn-group -->
                                </div>
                                <!-- /.pull-right -->
                            </div>
                        </div>
                    </div>
                    <!-- /. box -->
                </div>
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
<!-- iCheck -->
<!-- <script src="/plugins/iCheck/icheck.min.js"></script> -->
<!-- Page Script -->
<script>
    $(function () {
        //Enable iCheck plugin for checkboxes
        //iCheck for checkbox and radio inputs
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });

        //Enable check and uncheck all functionality
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });

        //Handle starring for glyphicon and font awesome
        $(".mailbox-star").click(function (e) {
            e.preventDefault();
            //detect type
            var $this = $(this).find("a > i");
            var glyph = $this.hasClass("glyphicon");
            var fa = $this.hasClass("fa");

            //Switch states
            if (glyph) {
                $this.toggleClass("glyphicon-star");
                $this.toggleClass("glyphicon-star-empty");
            }

            if (fa) {
                $this.toggleClass("fa-star");
                $this.toggleClass("fa-star-o");
            }
        });
    });
</script>

</body>
</html>
