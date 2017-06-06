<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fragments/head.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                        <a href="/mensajes/buzon" class="btn btn-primary btn-block margin-bottom">Volver a la Bandeja de Entrada</a>

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
                                    <li class="active"><a href="/eventos/buzon"><i class="fa fa-inbox"></i> Bandeja de Entrada
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
                                <h3 class="box-title">Nuevo Mensaje</h3>
                            </div>
                            <!-- /.box-header -->
                            <form method="POST" action="/mensajes/crear">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <div class="box-body">
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Para:" name="email">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Asunto:" name="asunto">
                                    </div>
                                    <div class="form-group">
                                        <textarea id="compose-textarea" class="form-control" name="texto" placeholder="Texto:">

                                        </textarea>
                                    </div>
                                </div>
                                <!-- /.box-body -->
                                <div class="box-footer">
                                    <div class="pull-right">
                                        <button type="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> Enviar mensaje</button>
                                    </div>
                                </div>
                            </form>
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
    <!-- iCheck -->
    <!-- <script src="/plugins/iCheck/icheck.min.js"></script>

    <!-- Bootstrap WYSIHTML5 -->
    <script src="<c:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" />"></script>
    <!-- Page Script -->
    <script>
        $(function () {
            //Add text editor
            $("#compose-textarea").wysihtml5();
        });
    </script>

</body>
</html>
