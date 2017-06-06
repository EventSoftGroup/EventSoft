<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
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
                    Nuevo Evento
                    <small>Panel para la creacion de un nuevo evento.</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>Eventos</a></li>
                    <li class="active">Crear Evento</li>
                </ol>
            </section>

            <section class="col-lg-6 connectedSortable">
                <div class="box box-warning">
                    <div class="box-header with-border">
                        <h3 class="box-title">Datos generales</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <springForm:form method="POST" name='formulario_crear_evento'  modelAttribute='evento' action="/eventos/crearEvento">

                            <!-- select -->
                            <div class="form-group">
                                <springForm:label path="categoria">Tipo de evento</springForm:label>
                                <springForm:select path="categoria" items="${CategoriasEvento}" cssClass="form-control select2" style="width: 45%;"/>
                            </div>

                            <div class="form-group">
                                <label path="email">Email cliente:</label>
                                <input name="email" class="form-control" placeholder="cliente@eventSoft.es" autofocus="true" type="email" />
                            </div>
                            <!-- text input -->
                            <div class="form-group">
                                <springForm:label path="nombre">Nombre del evento</springForm:label>
                                <springForm:input path="nombre" cssClass="form-control"  placeholder="Boda de..." type="text" />
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                <springForm:errors path="nombre" cssClass="alert-error" />
                            </div>
                            <div class="form-group">
                                <springForm:label path="lugar">Lugar del evento</springForm:label>
                                <springForm:input path="lugar" cssClass="form-control"  placeholder="Donde se van a desarrollar los hechos..." type="text" />
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                <springForm:errors path="lugar" cssClass="alert-error" />
                            </div>



                            <div class="form-group">
                                <springForm:label path="descripcion">Descripción</springForm:label>
                                <springForm:textarea path="descripcion" cssClass="form-control"  placeholder="Una breve descripción del evento..." type="text" />
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                <springForm:errors path="descripcion" cssClass="alert-error" />
                            </div>

                            <!--
                            <div class="form-group">
                                <label path="fechaInicio" for="fechaInicio">Fecha Inicio:</label>
                                <input name="fechaInicio" class="form-control" placeholder="dd/mm/yyyy" type="date" style="width: 45%;"/>
                                <springForm:errors path="fechaInicio" cssClass="alert-error" />
                            </div>
                            <div class="form-group">
                                <label path="fechaFin" for="fechaFin">Fecha Fin:</label>
                                <input name="fechaFin" class="form-control" placeholder="dd/mm/yyyy" type="date" style="width: 45%;"/>
                                <springForm:errors path="fechaFin" cssClass="alert-error" />
                            </div>
                            -->
                            <div class="form-group">
                                <springForm:label path="fechaInicio">Fecha inicio:</springForm:label>
                                <springForm:input path="fechaInicio" cssClass="form-control"  placeholder="Fecha inicio" type="date" style="width: 45%;"/>
                                <springForm:errors path="fechaInicio" cssClass="alert-error" />
                            </div>

                            <div class="form-group">
                                <springForm:label path="fechaFin">Fecha fin:</springForm:label>
                                <springForm:input path="fechaFin" cssClass="form-control"  placeholder="Fecha fin" type="date" style="width: 45%;"/>
                                <springForm:errors path="fechaFin" cssClass="alert-error" />
                            </div>

                            <div class="col-xs-4">
                                <button type="submit" class="btn btn-primary btn-block btn-flat">Crear evento</button>
                            </div>
                        </springForm:form>
                    </div>
                    <!-- /.box-body -->
                </div>
            </section>
            <section class="col-lg-6 connectedSortable">
        <!-- Calendar -->
        <div class="box box-solid bg-green-gradient">
            <div class="box-header">
                <i class="fa fa-calendar"></i>

                <h3 class="box-title">Calendar</h3>
                <!-- tools box -->
                <div class="pull-right box-tools">
                    <!-- button with a dropdown -->
                    <div class="btn-group">
                        <button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bars"></i></button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="#">Add new event</a></li>
                            <li><a href="#">Clear events</a></li>
                            <li class="divider"></li>
                            <li><a href="#">View calendar</a></li>
                        </ul>
                    </div>
                    <button type="button" class="btn btn-success btn-sm" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                    <button type="button" class="btn btn-success btn-sm" data-widget="remove"><i class="fa fa-times"></i>
                    </button>
                </div>
                <!-- /. tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
                <!--The calendar -->
                <div id="calendar" style="width: 100%"></div>
            </div>
        </div>
        <!-- /.box -->
    </section>

            <!-- /.box-body -->
        </div>

        <!-- footer -->
        <%@ include file="../fragments/footer.jspf" %>
        <!-- control-sidebar -->
        <%@ include file="../fragments/control-sidebar.jspf" %>
        <!-- Add the sidebar's background. This div must be placed
        immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>
    </div>

    <%@ include file="../fragments/plugins.jspf" %>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>

    <!-- Sparkline -->

    <script src="<c:url value="/resources/plugins/sparkline/jquery.sparkline.min.js" />"></script>

    <!-- jvectormap -->
    <script src="<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" />"></script>
    <script src="<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" />"></script>

    <!-- jQuery Knob Chart -->
    <!--  +++++++++++++++++++++++++++++ -->
    <script src="<c:url value="/resources/plugins/knob/jquery.knob.js" />"></script>

    <!-- daterangepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
    <script src="<c:url value="/resources/plugins/daterangepicker/daterangepicker.js" />"></script>

    <!-- datepicker -->
    <script src="<c:url value="/resources/plugins/datepicker/bootstrap-datepicker.js" />"></script>

    <!-- Bootstrap WYSIHTML5 -->
    <script src="<c:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" />"></script>

    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<c:url value="/resources/dist/js/pages/dashboard.js" />"></script>


</body>
</html>