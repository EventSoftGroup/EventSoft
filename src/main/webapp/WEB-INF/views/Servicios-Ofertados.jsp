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
                Buzón
                <small>13 mensajes nuevos</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Inicio</a></li>
                <li class="active">Buzón</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <!-- /.col -->
                <div class="col-md-9" id="bandeja_recibidos">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Bandeja de Entrada</h3>

                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <input type="text" class="form-control input-sm" placeholder="Buscar mensaje">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </div>
                            <!-- /.box-tools -->
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <c:if test="${not empty usuario.mensajes_recibidos}">
                            </c:if>
                            <div class="table-responsive mailbox-messages">
                                <table class="table table-hover table-striped">
                                    <tbody>

                                    <c:if test="${not empty usuario.mensajes_recibidos}">

                                            <c:forEach var="mensaje" items="${usuario.mensajes_recibidos}">
                                                <tr>
                                                    <!--<td><input type="checkbox"></td>-->
                                                    <td>
                                                        <a href="/mensajes/ver/${mensaje.id}" type="button" class="btn btn-default"><i class="fa fa-search"></i> Ver</a>
                                                        <a href="/mensajes/eliminar/${mensaje.id}" type="button" class="btn btn-default"><i class="fa fa-trash-o"></i> Eliminar</a>
                                                    </td>

                                                    <p style="display:none;"><c:catch var="exception">${mensaje.emisor.nombre}</c:catch></p>

                                                    <c:if test="${not empty exception}"> <!-- Profesional -->
                                                        <td class="mailbox-name"><a>${mensaje.emisor.empresa}</a></td>
                                                    </c:if>
                                                    <c:if test="${empty exception}"> <!-- Cliente -->
                                                        <td class="mailbox-name"><a>${mensaje.emisor.nombre}</a></td>
                                                    </c:if>

                                                    <td class="mailbox-subject"><b>${mensaje.asunto}</b> - ${fn:substring(mensaje.mensaje, 0, 35)}... </td>
                                                    <td class="mailbox-date">${mensaje.fechaEnvio}</td>
                                                </tr>
                                            </c:forEach>

                                    </c:if>

                                    </tbody>
                                </table>
                                <!-- /.table -->
                            </div>
                            <!-- /.mail-box-messages -->
                        </div>
                    </div>
                    <!-- /. box -->
                </div>
                <!-- /.col -->

                            <div class="table-responsive mailbox-messages">
                                <table class="table table-hover table-striped">
                                    <tbody>


                                    <c:if test="${not empty usuario.mensajes_enviados}">

                                        <c:forEach var="mensaje" items="${usuario.mensajes_enviados}">
                                            <tr>
                                                <!--<td><input type="checkbox"></td>-->
                                                <td>
                                                    <a href="/mensajes/ver/${mensaje.id}" class="btn btn-default"><i class="fa fa-search"></i> Ver</a>
                                                    <a href="/mensajes/eliminar/${mensaje.id}" class="btn btn-default"><i class="fa fa-trash-o"></i> Eliminar</a>
                                                </td>

                                                <p style="display:none;"><c:catch var="exception">${mensaje.emisor.nombre}</c:catch></p>

                                                <c:if test="${not empty exception}"> <!-- Profesional -->
                                                    <td onclick="location='/mensajes/ver/${mensaje.id}'" class="mailbox-name"><a href="#">${mensaje.emisor.empresa}</a></td>
                                                </c:if>
                                                <c:if test="${empty exception}"> <!-- Cliente -->
                                                    <td onclick="location='/mensajes/ver/${mensaje.id}'" class="mailbox-name"><a href="#">${mensaje.emisor.nombre}</a></td>
                                                </c:if>

                                                <td class="mailbox-subject"><b>${mensaje.asunto}</b> - ${fn:substring(mensaje.mensaje, 0, 35)}... </td>
                                                <td class="mailbox-date">${mensaje.fechaEnvio}</td>
                                            </tr>
                                        </c:forEach>

                                    </c:if>

                                    </tbody>
                                </table>
                                <!-- /.table -->
                            </div>
                            <!-- /.mail-box-messages -->
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer no-padding">
                            <c:if test="${not empty usuario.mensajes_enviados}">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <!--<button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                                </button>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                    <button type="button" class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                                    <button type="button" class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
                                </div>-->
                                <!-- /.btn-group -->
                                <!--<button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>-->
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
                            </c:if>
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
<script src="/dist/js/buzonMail.js"></script>
<!-- iCheck -->
<!-- Page Script -->
<script>
    $(function () {
        //Enable iCheck plugin for checkboxes
        //iCheck for checkbox and radio inputs
        /*$('.mailbox-messages input[type="checkbox"]').iCheck({
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
        });*/

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
