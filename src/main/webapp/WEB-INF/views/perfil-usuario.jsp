<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>

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
                Perfil personal
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Inicio</a></li>
                <li class="active">Perfil personal</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-3">
                    <!-- Profile Image -->
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <img class="profile-user-img img-responsive img-circle" src="/dist/img/user4-128x128.jpg"
                                 alt="User profile picture">
                            <h3 class="profile-username text-center">
                                <c:catch var="exception"><c:out value="${usuario.nombre}"></c:out></c:catch>

                                <c:if test="${not empty exception}"> <!-- Profesional -->
                                        <c:out value="${usuario.empresa}"></c:out>
                                </c:if>
                            </h3>
                            <!-- <p class="text-muted text-center">Florista Web</p>-->
                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <c:if test="${rol eq 'Organizador'}">
                                        <b>Eventos</b> <a class="pull-right">
                                            <c:if test="${not empty usuario.eventos}">
                                                <c:out value="${usuario.eventos.size()}"></c:out>
                                            </c:if>
                                        <c:if test="${empty usuario.eventos}">
                                            0
                                        </c:if>
                                        </a>
                                    </c:if>
                                    <c:if test="${rol eq 'Proveedor'}">
                                        <b>Servicios Ofertados</b> <a class="pull-right">
                                        <c:if test="${not empty usuario.servicios}">
                                            <c:out value="${usuario.servicios.size()}"></c:out>
                                        </c:if>
                                        <c:if test="${empty usuario.servicios}">
                                            0
                                        </c:if>
                                        </a>
                                    </c:if>
                                    <c:if test="${rol eq 'Cliente'}">
                                        <b>Eventos Asociados</b> <a class="pull-right">
                                        <c:if test="${not empty usuario.eventos_Adscritos}">
                                            <c:out value="${usuario.eventos_Adscritos.size()}"></c:out>
                                        </c:if>
                                        <c:if test="${empty usuario.eventos_Adscritos}">
                                            0
                                        </c:if>
                                        </a>
                                    </c:if>
                                </li>
                            </ul>
                            <a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-block"><b>Contactar</b></a>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                    <!-- About Me Box -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Información</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">

                            <strong><i class="fa fa-book margin-r-5"></i> Nombre</strong>
                            <p class="text-muted">
                                <c:catch var="exception"><c:out value="${usuario.nombre}"></c:out></c:catch>

                                <c:if test="${not empty exception}"> <!-- Profesional -->
                                    <c:out value="${usuario.empresa}"></c:out>
                                </c:if>
                            </p>
                            <hr>
                            <strong><i class="fa fa-map-marker margin-r-5"></i> Dirección</strong>
                            <p class="text-muted"><c:out value="${usuario.direccion}"></c:out></p>
                            <hr>
                            <strong><i class="fa fa-map-marker margin-r-5"></i>Localidad</strong>
                            <p class="text-muted"><c:out value="${usuario.localidad}"></c:out></p>
                            <hr>
                            <strong><i class="fa fa-map-marker margin-r-5"></i>Provincia</strong>
                            <p class="text-muted"><c:out value="${usuario.provincia}"></c:out></p>
                            <hr>
                            <strong><i class="fa fa-map-marker margin-r-5"></i> Código Postal</strong>
                            <p class="text-muted"><c:out value="${usuario.codigoPostal}"></c:out></p>
                            <hr>
                            <strong><i class="fa fa-map-marker margin-r-5"></i> Teléfono</strong>
                            <p class="text-muted"><c:out value="${usuario.telefono}"></c:out></p>
                            <hr>
                            <!--
                            <strong><i class="fa fa-pencil margin-r-5"></i> Servicios</strong>
                            <p>
                                <span class="label label-info">Flores a domicilio</span>
                                <span class="label label-info">Ramos</span>
                                <span class="label label-info">Bodas</span>
                                <span class="label label-info">Fiestas</span>
                                <span class="label label-info">Arreglos florales</span>
                            </p>
                            <hr>
                            -->
                            <strong><i class="fa fa-file-text-o margin-r-5"></i> Opciones</strong>
                            <p>
                                <button type="button" class="btn btn-primary" data-widget="collapse"> Enviar mail
                                </button>
                                <button type="button" class="btn btn-warning" data-widget="collapse"> Modificar datos
                                </button>
                                <form method="POST" action="./eliminar">
                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                </form>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <div class="col-md-9">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#activity" data-toggle="tab">Eventos</a></li>
                            <!--<li><a href="#timeline" data-toggle="tab">Valoraciones</a></li>-->
                            <li><a href="#settings" data-toggle="tab">Modificar Datos</a></li>
                            <c:if test="${rol eq 'Proveedor'}">
                                <li><a href="#añadirServicio" data-toggle="tab">Añadir Servicio</a></li>
                            </c:if>
                        </ul>
                        <div class="tab-content">
                            <div class="active tab-pane" id="activity">
                                <!-- Post -->
                                <div class="post">
                                    <div class="user-block">
                                        <img class="img-circle img-bordered-sm" src="/dist/img/user1-128x128.jpg"
                                             alt="user image">
                                        <span class="username">
                          <a href="#">Boda de Jonathan Burke Jr.</a>
                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                        </span>
                                        <span class="description">Shared publicly - 7:30 PM today</span>
                                    </div>
                                    <!-- /.user-block -->
                                    <p>
                                        Lorem ipsum represents a long-held tradition for designers, typographers and the
                                        like. Some people hate it and argue for its demise, but others ignore the hate
                                        as they create awesome tools to help create filler text for everyone from bacon
                                        lovers to Charlie Sheen fans.
                                    </p>
                                    <div class="row margin-bottom">
                                        <div class="col-sm-3">
                                            <img class="img-responsive" src="/dist/img/Flores/1.jpg" alt="Photo">
                                            <!-- /.row -->
                                        </div>
                                        <div class="col-sm-3">
                                            <img class="img-responsive" src="/dist/img/Flores/2.jpg" alt="Photo">
                                        </div>
                                        <div class="col-sm-6">
                                            <img class="img-responsive" src="/dist/img/Flores/4.jpg" alt="Photo">
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <ul class="list-inline">
                                        <li><a href="#" class="link-black text-sm"><i
                                                class="fa fa-share margin-r-5"></i> Share</a></li>
                                        <li><a href="#" class="link-black text-sm"><i
                                                class="fa fa-thumbs-o-up margin-r-5"></i> Like</a>
                                        </li>
                                        <li class="pull-right">
                                            <a href="#" class="link-black text-sm"><i
                                                    class="fa fa-comments-o margin-r-5"></i> Comments
                                                (5)</a></li>
                                    </ul>
                                    <input class="form-control input-sm" type="text" placeholder="Type a comment">
                                </div>
                                <!-- /.post -->
                                <!-- Post -->
                                <div class="post clearfix">
                                    <div class="user-block">
                                        <img class="img-circle img-bordered-sm" src="/dist/img/user7-128x128.jpg"
                                             alt="User Image">
                                        <span class="username">
                          <a href="#">Fiesta cumpleaños de Sarah Ross</a>
                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                        </span>
                                        <span class="description">Sent you a message - 3 days ago</span>
                                    </div>
                                    <!-- /.user-block -->
                                    <div class="row margin-bottom">
                                        <div class="col-sm-6">
                                            <img class="img-responsive" src="/dist/img/Flores/7.jpg" alt="Photo">
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-sm-6">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <img class="img-responsive" src="/dist/img/Flores/3.jpg"
                                                         alt="Photo">
                                                </div>
                                                <!-- /.col -->
                                                <div class="col-sm-6">
                                                    <img class="img-responsive" src="/dist/img/Flores/5.jpg"
                                                         alt="Photo">
                                                    <br>
                                                    <img class="img-responsive" src="/dist/img/Flores/6.jpg"
                                                         alt="Photo">
                                                </div>
                                                <!-- /.col -->
                                            </div>
                                            <!-- /.row -->
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->
                                    <ul class="list-inline">
                                        <li><a href="#" class="link-black text-sm"><i
                                                class="fa fa-share margin-r-5"></i> Share</a></li>
                                        <li><a href="#" class="link-black text-sm"><i
                                                class="fa fa-thumbs-o-up margin-r-5"></i> Like</a>
                                        </li>
                                        <li class="pull-right">
                                            <a href="#" class="link-black text-sm"><i
                                                    class="fa fa-comments-o margin-r-5"></i> Comments
                                                (5)</a></li>
                                    </ul>
                                    <input class="form-control input-sm" type="text" placeholder="Type a comment">
                                </div>
                                <!-- /.post -->
                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="settings">
                                <springForm:form method="post" name="form_modificar_usuario" modelAttribute="usuarioAModificar" action="/usuarios/modificar">
                                    <!-- Dirección -->
                                    <div class="form-group has-feedback">
                                        <springForm:input path="direccion" cssClass="form-control" autofocus="true" placeholder="Dirección" type="text"/>
                                        <springForm:errors path="direccion" cssClass="alert-error" />
                                        <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
                                    </div>
                                    <!-- Localidad -->
                                    <div class="form-group has-feedback">
                                        <springForm:input path="localidad" cssClass="form-control" placeholder="Localidad" type="text"/>
                                        <springForm:errors path="localidad" cssClass="alert-error" />
                                        <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
                                    </div>
                                    <!-- Provincia -->
                                    <div class="form-group has-feedback">
                                        <springForm:input path="provincia" cssClass="form-control" placeholder="Provincia" type="text"/>
                                        <springForm:errors path="provincia" cssClass="alert-error" />
                                        <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
                                    </div>
                                    <!-- Código postal -->
                                    <div class="form-group has-feedback">
                                        <springForm:input path="codigoPostal" cssClass="form-control" placeholder="Código postal" type="text"/>
                                        <springForm:errors path="codigoPostal" cssClass="alert-error" />
                                        <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
                                    </div>
                                    <!-- Teléfono -->
                                    <div class="form-group has-feedback">
                                        <springForm:input path="telefono" cssClass="form-control" placeholder="Teléfono" type="text"/>
                                        <springForm:errors path="telefono" cssClass="alert-error" />
                                        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                                    </div>
                                    <div class="row">
                                        <!-- /.col -->
                                        <div class="col-xs-4">
                                            <button type="submit" class="btn btn-primary btn-block btn-flat">Modificar</button>
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                </springForm:form>
                            </div>
                            <!-- /.tab-pane -->

                            <div class="tab-pane" id="añadirServicio">
                                <form class="form-horizontal" method="post" action="/servicios/crear">

                                    <div class="form-group">
                                        <label for="nombreServicio" class="col-sm-2 control-label">Nombre</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="nombreServicio" name="nombreServicio" placeholder="Ej.: Jardineria" value="">
                                        </div>
                                    </div>
                                    <!-- select -->
                                    <div class="form-group">
                                        <label for="listaServicios" class="col-sm-2 control-label">Tipo de Servicio</label>
                                        <div class="col-sm-10">
                                            <select class="form-control" id="listaServicios" name="listaServicios">
                                                <c:forEach var="item" items="${listaTiposServicio}">
                                                    <option value="${item}">${item}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- textarea -->
                                    <div class="form-group">
                                        <label for="descripcion" class="col-sm-2 control-label">Descripción</label>
                                        <div class="col-sm-10">
                                            <textarea class="form-control" rows="3" id="descripcion" name="descripcion" placeholder="Ej.: Servicio de florista para bodas"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10">
                                            <input type="hidden" id="idUsuario2" name="idUsuario" value="${usuario.id}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-danger">Añadir Servicio</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- /.tab-pane -->

                        </div>
                        <!-- /.tab-content -->
                    </div>
                    <!-- /.nav-tabs-custom -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>


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
</body>
</html>
