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
                <!-- /.col -->
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Boda en Marugán</h3>

                            <div class="box-tools pull-right">
                                <a href="#" class="btn btn-box-tool" data-toggle="tooltip" title="Previous"><i class="fa fa-chevron-left"></i></a>
                                <a href="#" class="btn btn-box-tool" data-toggle="tooltip" title="Next"><i class="fa fa-chevron-right"></i></a>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-read-info">
                                <h3><b>Cancelación del evento</b></h3>
                                <h5>De: Tomás Muñoz Testón (Organizador del evento)
                                    <span class="mailbox-read-time pull-right">15 Feb. 2016 11:03 PM</span></h5>
                            </div>
                            <!-- /.mailbox-controls -->
                            <div class="mailbox-read-message">
                                <p>Hola a todos,</p>

                                <p>Por motivos mayores, se suspende el evento del dia 17 de Mayo. Se os abonará a todos un recibo con vuestros honorarios.</p>

                                <p>Gracias y disculpar las molestias.</p>

                                <p>Un saludo,</p>

                                <p>Tomás Muñoz.</p>
                            </div>
                            <!-- /.mailbox-read-message -->
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box-footer -->
                    <div class="box-footer">
                        <div class="pull-right">
                            <button type="button" class="btn btn-default"><i class="fa fa-envelope"></i> Enviar un mensaje</button>
                        </div>
                        <button type="button" class="btn btn-default"><i class="fa fa-trash-o"></i> Eliminar</button>
                        <button type="button" class="btn btn-default"><i class="fa fa-print"></i> Imprimir</button>
                    </div>
                    <!-- /.box-footer -->
                </div>
                <!-- /. box -->
            </div>
            <!-- /.col -->
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
