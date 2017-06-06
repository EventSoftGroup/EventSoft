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
                    <!--<small>13 mensajes nuevos</small>-->
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>Inicio</a></li>
                    <li class="active">Buzón</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-3">
                        <a href="/mensajes/mensaje-nuevo" class="btn btn-primary btn-block margin-bottom">Nuevo mensaje</a>
                        <a href="/mensajes/buzon" class="btn btn-primary btn-block margin-bottom">Volver</a>

                        <!--<div class="box box-solid">
                            <div class="box-header with-border">
                                <h3 class="box-title">Carpetas</h3>

                                <div class="box-tools">
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="box-body no-padding">
                                <ul class="nav nav-pills nav-stacked">
                                    <li class="active"><a href="/mensajes/buzon"><i class="fa fa-inbox"></i> Bandeja de Entrada
                                        <span class="label label-primary pull-right">12</span></a></li>
                                    <li><a href="#"><i class="fa fa-envelope-o"></i> Enviados</a></li>
                                    <li><a href="#"><i class="fa fa-star"></i> Favoritos</a></li>
                                    <li><a href="#"><i class="fa fa-trash-o"></i> Papelera<span class="label label-warning pull-right">65</span></a></li>
                                </ul>
                            </div>

                        </div>-->
                    </div>
                    <!-- /.col -->
                    <div class="col-md-9">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">Leer Mensaje</h3>

                                <div class="box-tools pull-right">
                                    <a href="#" class="btn btn-box-tool" data-toggle="tooltip" title="Previous"><i class="fa fa-chevron-left"></i></a>
                                    <a href="#" class="btn btn-box-tool" data-toggle="tooltip" title="Next"><i class="fa fa-chevron-right"></i></a>
                                </div>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body no-padding">
                                <div class="mailbox-read-info">
                                    <h3><c:out value="${mensaje.asunto}"></c:out></h3>
                                    <!--<h5>De: -->
                                        <span class="mailbox-read-time pull-right"><c:out value="${mensaje.fechaEnvio}"></c:out></span></h5>
                                </div>
                                <!-- /.mailbox-read-info -->
                                <div class="mailbox-controls with-border text-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" data-container="body" title="Delete">
                                            <i class="fa fa-trash-o"></i></button>
                                        <button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" data-container="body" title="Reply">
                                            <i class="fa fa-reply"></i></button>
                                        <button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" data-container="body" title="Forward">
                                            <i class="fa fa-share"></i></button>
                                    </div>
                                    <!-- /.btn-group -->
                                    <button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" title="Print">
                                        <i class="fa fa-print"></i></button>
                                </div>
                                <!-- /.mailbox-controls -->
                                <div class="mailbox-read-message">
                                    <c:out value="${mensaje.mensaje}"></c:out>
                                </div>
                                <!-- /.mailbox-read-message -->
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">

                            </div>
                            <!-- /.box-footer -->
                            <div class="box-footer">
                                <div class="pull-right">
                                    <button type="button" class="btn btn-default"><i class="fa fa-reply"></i> Responder</button>
                                    <button type="button" class="btn btn-default"><i class="fa fa-share"></i> Reenviar</button>
                                </div>
                                <button type="button" class="btn btn-default"><i class="fa fa-trash-o"></i> Eliminar</button>
                                <button type="button" class="btn btn-default"><i class="fa fa-print"></i> Imprimir</button>
                            </div>
                            <!-- /.box-footer -->
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

</body>
</html>
