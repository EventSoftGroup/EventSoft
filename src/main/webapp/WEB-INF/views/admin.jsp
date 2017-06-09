<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                Administración
                <small>Proveedores</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- CONTADORES DE USUARIOS -->
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <div class="col-lg-2 col-xs-6">
                    <!-- small box  PROVEEDORES-->
                    <div class="small-box bg-teal">
                        <div class="inner">
                            <h3><c:out value="${fn:length(listaClinetes)}"></c:out></h3>
                            <p>Num clientes</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person"></i>
                        </div>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-2 col-xs-6">
                    <!-- small box ORGANIZADORES-->
                    <div class="small-box bg-light-blue">
                        <div class="inner">
                            <h3><c:out value="${fn:length(listaOrganizadores)}"></c:out></h3>
                            <p>Num organizadores</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person"></i>
                        </div>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-2 col-xs-6">
                    <!-- small box USUARIOS-->
                    <div class="small-box bg-blue">
                        <div class="inner">
                            <h3><c:out value="${fn:length(listaProveedores)}"></c:out></h3>
                            <p>Num proveedores</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person"></i>
                        </div>
                    </div>
                </div>

                <div class="col-lg-2 col-xs-6">
                    <!-- small box USUARIOS-->
                    <div class="small-box bg-lime">
                        <div class="inner">
                            <h3><c:out value="${fn:length(listaServicios)}"></c:out></h3>
                            <p>Servicios ofertados</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-stats-bars"></i>
                        </div>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-2 col-xs-6">
                    <!-- small box ECENTOS ACTUALES-->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <h3><c:out value="${fn:length(listaEventos)}"></c:out></h3>
                            <p>Eventos organizados</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-stats-bars"></i>
                        </div>
                    </div>
                </div>

                <!-- ./col -->
                <div class="col-lg-2 col-xs-6">
                    <!-- small box ECENTOS ACTUALES-->
                    <div class="small-box bg-gray">
                        <div class="inner">
                            <h3><c:out value="${numTotalMensajes}"></c:out></h3>
                            <p>Mensajes enviados</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-android-mail"></i>
                        </div>
                    </div>
                </div>
                <!-- ./col -->
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li id="tabClientes" class=""><a href="#Clientes" data-toggle="tab">Clientes</a></li>
                            <li><a href="#Proveedores" data-toggle="tab">Proveedores</a></li>
                            <li><a href="#Organizadores" data-toggle="tab">Organizadores</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane" id="Clientes">

                                <div class="table-responsive mailbox-messages">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th class="text-center">      </th>
                                            <th class="text-center">Email</th>
                                            <th class="text-center">Nombre</th>
                                            <th class="text-center">Provincia</th>
                                            <th class="text-center">Telefono</th>
                                            <th class="text-center">      </th>
                                        </tr>
                                        </thead>

                                        <tbody>

                                        <c:if test="${not empty listaClinetes}">

                                            <c:forEach var="cli" items="${listaClinetes}">
                                                <tr>
                                                    <!--<td><input type="checkbox"></td>-->
                                                    <td><a href="/servicios/buscar/${cli.id}" type="button"
                                                           class="btn btn-default text-center"><i class="fa fa-search"></i> Ver</a>
                                                    </td>

                                                    <td class="mailbox-subject text-center"><c:out value="${cli.email}"></c:out></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${cli.nombre}"></c:out></b></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${cli.provincia}"></c:out></b></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${cli.telefono}"></c:out></b></td>

                                                    <td class="mailbox-subject">
                                                        <a type="button" class="btn btn-default text-center botonEliminarServicio" id="cliente-${cli.id}" data-id="${cli.id}"><i class="fa fa-trash-o"></i>Eliminar</a></td>
                                                </tr>
                                            </c:forEach>

                                        </c:if>

                                        </tbody>
                                    </table>
                                    <!-- /.table -->
                                </div>



                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="Proveedores">

                                <div class="table-responsive mailbox-messages">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th class="text-center">      </th>
                                            <th class="text-center">Email</th>
                                            <th class="text-center">Empresa</th>
                                            <th class="text-center">Provincia</th>
                                            <th class="text-center">Telefono</th>
                                            <th class="text-center">      </th>
                                        </tr>
                                        </thead>

                                        <tbody>

                                        <c:if test="${not empty listaProveedores}">

                                            <c:forEach var="prov" items="${listaProveedores}">
                                                <tr>
                                                    <!--<td><input type="checkbox"></td>-->
                                                    <td><a href="/servicios/buscar/${prov.id}" type="button"
                                                           class="btn btn-default text-center"><i class="fa fa-search"></i> Ver</a>
                                                    </td>

                                                    <td class="mailbox-subject text-center"><c:out value="${prov.email}"></c:out></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${prov.empresa}"></c:out></b></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${prov.provincia}"></c:out></b></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${prov.telefono}"></c:out></b></td>

                                                    <td class="mailbox-subject"><a type="button" class="btn btn-default text-center botonEliminarServicio" id="proveedor-${prov.id}" data-id="${prov.id}"><i class="fa fa-trash-o"></i>Eliminar</a></td>
                                                </tr>
                                            </c:forEach>

                                        </c:if>

                                        </tbody>
                                    </table>
                                    <!-- /.table -->
                                </div>



                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="Organizadores">
                                <div class="table-responsive mailbox-messages">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th class="text-center">      </th>
                                            <th class="text-center">Email</th>
                                            <th class="text-center">Empresa</th>
                                            <th class="text-center">Provincia</th>
                                            <th class="text-center">Telefono</th>
                                            <th class="text-center">      </th>
                                        </tr>
                                        </thead>

                                        <tbody>

                                        <c:if test="${not empty listaOrganizadores}">

                                            <c:forEach var="orga" items="${listaOrganizadores}">
                                                <tr>
                                                    <!--<td><input type="checkbox"></td>-->
                                                    <td><a href="/servicios/buscar/${orga.id}" type="button"
                                                           class="btn btn-default text-center"><i class="fa fa-search"></i> Ver</a>
                                                    </td>

                                                    <td class="mailbox-subject text-center">$<c:out value="{orga.email}"></c:out></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${orga.empresa}"></c:out></b></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${orga.provincia}"></c:out></b></td>
                                                    <td class="mailbox-subject text-center"><b><c:out value="${orga.telefono}"></c:out></b></td>

                                                    <td class="mailbox-subject">
                                                        <a type="button" class="btn btn-default text-center botonEliminarServicio" id="organizador-${prov.id}" data-id="${prov.id}"><i class="fa fa-trash-o"></i>Eliminar</a></td>
                                                </tr>
                                            </c:forEach>

                                        </c:if>

                                        </tbody>
                                    </table>
                                    <!-- /.table -->
                                </div>



                            </div>
                            <!-- /.tab-pane -->

                        </div>
                        <!-- /.tab-content -->
                    </div>
                    <!-- /.nav-tabs-custom -->
                </div>
                <!-- /.col -->

                <div class="col-md-6">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class=""><a href="#Servicios" data-toggle="tab">Servicios</a></li>
                            <li><a href="#Eventos" data-toggle="tab">Eventos</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class=" tab-pane" id="Servicios">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <tr>
                                        <th class="text-center col-md-1">      </th>
                                        <th class="text-center col-md-1">Tipo servicio</th>
                                        <th class="text-center col-md-1">Nombre</th>
                                        <th class="text-center col-md-1">Descripción</th>
                                        <th class="text-center col-md-1">Fecha de Registro</th>
                                        <th class="text-center col-md-1">      </th>
                                    </tr>
                                    </thead>

                                    <tbody>

                                    <c:if test="${not empty listaServicios}">

                                        <c:set var="count" value="1" scope="page" />
                                        <c:forEach var="servicio" items="${listaServicios}">
                                            <tr>
                                                <!--<td><input type="checkbox"></td>-->
                                                <td class="col-md-1">
                                                    <a href="/servicios/buscar/${servicio.id}" type="button"
                                                       class="btn btn-default text-center "><i class="fa fa-search"></i> Ver</a>

                                                </td>
                                                <!-- <p style="display:none;"><c:catch var="exception"><c:out value="${servicio.nombre}"></c:out></c:catch></p>-->
                                                <td class="mailbox-subject text-center col-md-1"><c:out value="${servicio.tipo}"></c:out></td>
                                                <td class="mailbox-subject text-center col-md-1"><b><c:out value="${servicio.nombre}"></c:out></b></td>
                                                <td class="mailbox-subject col-md-1"><c:out value="${fn:substring(servicio.descripcion, 0, 70)}"></c:out> ...</td>
                                                <td class="mailbox-date text- col-md-1">
                                                    <fmt:formatDate type = "date" value = "${servicio.fechaRegistro}" />
                                                </td>
                                                <td class="mailbox-subject col-md-1"><a type="button" class="btn btn-default text-center botonEliminarServicio" id="servicio-${servicio.id}" data-id="${servicio.id}"><i class="fa fa-trash-o"></i>Eliminar</a></td>
                                            </tr>
                                        </c:forEach>

                                    </c:if>

                                    </tbody>
                                </table>


                            </div>
                            <div class="tab-pane" id="Eventos">
                                <div class="table-responsive mailbox-messages">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th class="text-center">      </th>
                                            <th class="text-center">Tipo evento</th>
                                            <th class="text-center">Nombre</th>
                                            <th class="text-center">Descripción</th>
                                            <th class="text-center">Fecha de Inicio</th>
                                            <th class="text-center">Fecha de Fin</th>
                                            <th class="text-center">      </th>
                                        </tr>
                                        </thead>

                                        <tbody>

                                        <c:if test="${not empty listaEventos}">

                                            <c:forEach var="evento" items="${listaEventos}">
                                                <tr>
                                                    <!--<td><input type="checkbox"></td>-->
                                                    <td>
                                                        <a href="/servicios/buscar/${evento.id}" type="button"
                                                           class="btn btn-default text-center"><i class="fa fa-search"></i> Ver</a>

                                                    </td>
                                                    <td class="mailbox-subject text-center"><c:out value="${evento.categoria}"></c:out></td>
                                                    <!-- <p style="display:none;"><c:catch var="exception"><c:out value="${evento.nombre}"></c:out></c:catch></p>-->

                                                    <td class="mailbox-subject text-center"><b><c:out value="${evento.nombre}"></c:out></b></td>
                                                    <td class="mailbox-subject"><c:out value="${fn:substring(evento.descripcion, 0, 30)}"></c:out> ...</td>
                                                    <td class="mailbox-date text-center">
                                                        <fmt:formatDate type = "date" value = "${evento.fechaInicio}" />
                                                    </td>
                                                    <td class="mailbox-date text-center">
                                                        <fmt:formatDate type = "date" value = "${evento.fechaFin}" />
                                                    </td>
                                                    <td class="mailbox-subject"><a type="button" class="btn btn-default text-center botonEliminarServicio" id="evento-${evento.id}" data-id="${evento.id}"><i class="fa fa-trash-o"></i>Eliminar</a></td>
                                                </tr>
                                            </c:forEach>

                                        </c:if>

                                        </tbody>
                                    </table>
                                    <!-- /.table -->
                                </div>

                            </div>
                        </div>

                    </div>
                    <!-- /.tab-content -->
                </div>
                <!-- /.nav-tabs-custom -->
            </div>
            <!-- /.row -->

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



</body>
</html>