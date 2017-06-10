<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fragments/head.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Mis eventos
        <small></small>
        <c:catch var="exception"><span id="mensajeError" class="alert-error"><c:out value="${mensajeError}" ></c:out></span></c:catch>
        <c:catch var="exception"><span id="mensaje" class="alert-success"><c:out value="${mensaje}" ></c:out></span></c:catch>

      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Mis Eventos</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box" id="box_sel_evento">
        <div class="box-header with-border">
          <h3 class="box-title">Selecciona el evento</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body" id="panel_eventos">
          <div class="col-md-5">
            <div class="form-group">
              <label>Selecciona el evento que quieras visualizar</label>
              <select id="eventos" class="form-control select2" style="width: 100%;">

              </select>
              <c:if test="${rol eq 'Organizador'}">
                <button id="aniadirServicio" class="btn btn-primary">Añadir un servicio</button>
              </c:if>
              <button id="mostrarEventosTodos" class="btn btn-primary">Mostrar todos los eventos</button>
              <button id="ocultarEventos" class="btn btn-primary">Ocultar los eventos</button>
            </div>
            <!-- /.form-group -->
          </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">

        </div>
        <!-- /.box-footer-->
      </div>
      <div class="box" id="box_mostrar_eventos">
        <div class="box-header with-border">
          <h3 class="box-title">Selecciona el evento</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
          <div class="col-md-5">
            <div class="form-group">
              <label>Selecciona el evento que quieras visualizar</label>
              <select id="eventos" class="form-control select2" style="width: 100%;">

              </select>
              <button id="aniadirServicio" class="btn btn-primary">Añadir un servicio</button>
              <button id="mostrarEventos" class="btn btn-primary">Mostrar todos mis eventos</button>
            </div>
            <!-- /.form-group -->
          </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">

        </div>
        <!-- /.box-footer-->
      </div>


      <div class="box" id="box_sel_categoria" style="display:none;">
        <div class="box-header with-border">
          <h3 id="titulo_categoria" class="box-title">Selecciona la categoria</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
        <div class="col-md-6">
          <div class="form-group">
            <label>Selecciona la categoria que quieras visualizar</label>
            <select id="categorias" class="form-control select2" style="width: 100%;">

                <c:forEach var="cat" items="${listaTiposServicio}">
                  <option value="${cat}"><c:out value="${cat}"></c:out></option>
                </c:forEach>

            </select>
            <button id="buscarPorCategoria" class="btn btn-primary">buscar servicios por esta categoria</button>
            <button id="sel_evento_nuevo" class="btn btn-primary">Seleccionar un evento nuevo</button>
          </div>
          <!-- /.form-group -->
        </div>
      </div>
        <!-- /.box-body -->
        <div class="box-footer">

        </div>
        <!-- /.box-footer-->
      </div>

      <div class="box" id="box_sel_categoria_2" style="display:none;">
        <div class="box-header with-border">
          <h3 id="titulo_categoria_2" class="box-title"></h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
          <div class="col-md-12">
            <div class="form-group">
              <div id="demoform">
                <label id="label_listado_servicios">Selecciona los eventos que quieras incluir</label>
                <select id="selectServicios" multiple="multiple" size="10" name="mi_duallist[]">

                </select>
                <br>
                <button id="guardar_eventos" type="submit" class="btn btn-primary">Guardar</button>
                <button id="cambiar_evento" class="btn btn-primary">Cambiar evento</button>
                <button id="cambiar_categoria" class="btn btn-primary">Cambiar categoria</button>
              </div>
            </div>
            <!-- /.form-group -->
          </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">

        </div>
        <!-- /.box-footer-->
      </div>

      <div class="row" id="cargando" style="display: block;">
        <!-- /.col -->
        <div class="col-md-9">
          <p>Cargando los eventos, un momento por favor...</p>
          <!-- /. box -->
        </div>
        <!-- /.col -->

        <div class="table-responsive mailbox-messages">

        </div>
        <!-- /.mail-box-messages -->
      </div>

      <!-- row -->
      <div class="row" id="panelTodosLosEventos">
        <!-- /.col -->
        <div class="col-md-12" id="bandeja_recibidos">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Todos los eventos</h3>


            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="table-responsive mailbox-messages">
                <table class="table table-hover table-striped" id="tabla_eventos">
                  <thead>
                  <tr>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Categoria</th>
                    <th class="text-center">Descripcion</th>
                    <th class="text-center">Lugar</th>
                    <th class="text-center">Fecha inicio</th>
                    <th class="text-center">Fecha fin</th>
                    <th class="text-center">      </th>
                  </tr>
                  </thead>

                  <tbody>
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

        </div>
        <!-- /.mail-box-messages -->
      </div>

      <div class="row" id="panelUnEvento">
        <!-- /.col -->
        <div class="col-md-12" id="bandeja_recibido">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Datos del evento</h3>


            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="table-responsive mailbox-messages">
                <table class="table table-hover table-striped" id="tabla_evento">
                  <thead>
                  <tr>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Categoria</th>
                    <th class="text-center">Descripcion</th>
                    <th class="text-center">Lugar</th>
                    <th class="text-center">Fecha inicio</th>
                    <th class="text-center">Fecha fin</th>
                    <th class="text-center">      </th>
                  </tr>
                  </thead>

                  <tbody>
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

        </div>
        <!-- /.mail-box-messages -->
      </div>


      <!-- /.row -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <%@ include file="../fragments/footer.jspf" %>
  <!-- control-sidebar -->
  <%@ include file="../fragments/control-sidebar.jspf" %>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<%@ include file="../fragments/plugins.jspf" %>
<script src="<c:url value="/resources/dist/js/eventos.js" />"></script>
<script src="<c:url value="/resources/dist/js/jquery.bootstrap-duallistbox.js" />"></script>
</body>
</html>
