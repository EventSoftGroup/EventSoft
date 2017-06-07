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
                    Proveedores
                    <small>Panel de Control</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>Inicio</a></li>
                    <li class="active">Proveedores</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <section class="col-md-7 connectedSortable">
                        <!-- Your Page Content Here -->
                        <!-- TO DO List -->
                        <div class="box box-warning">
                            <div class="box-header">
                                <i class="ion ion-clipboard"></i>

                                <h3 class="box-title">Lista de Tareas</h3>

                                <div class="box-tools pull-right">
                                    <ul class="pagination pagination-sm inline">
                                        <li><a href="#">&laquo;</a></li>
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">&raquo;</a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <ul class="todo-list">
                                    <li>
                                        <!-- drag handle -->
                                        <span class="handle">
                            <i class="fa fa-ellipsis-v"></i>
                            <i class="fa fa-ellipsis-v"></i>
                          </span>
                                        <!-- checkbox -->
                                        <input type="checkbox" value="">
                                        <!-- todo text -->
                                        <span class="text">Comprar materias primas</span>
                                        <!-- Emphasis label -->
                                        <small class="label label-danger"><i class="fa fa-clock-o"></i> 3 horas </small>
                                        <!-- General tools such as edit or delete-->
                                        <div class="tools">
                                            <i class="fa fa-edit"></i>
                                            <i class="fa fa-trash-o"></i>
                                        </div>
                                    </li>
                                    <li>
                          <span class="handle">
                            <i class="fa fa-ellipsis-v"></i>
                            <i class="fa fa-ellipsis-v"></i>
                          </span>
                                        <input type="checkbox" value="">
                                        <span class="text">Montar carpa</span>
                                        <small class="label label-info"><i class="fa fa-clock-o"></i> 7 horas</small>
                                        <div class="tools">
                                            <i class="fa fa-edit"></i>
                                            <i class="fa fa-trash-o"></i>
                                        </div>
                                    </li>
                                    <li>
                          <span class="handle">
                            <i class="fa fa-ellipsis-v"></i>
                            <i class="fa fa-ellipsis-v"></i>
                          </span>
                                        <input type="checkbox" value="">
                                        <span class="text">Recoger materiales</span>
                                        <small class="label label-warning"><i class="fa fa-clock-o"></i> 1 dia</small>
                                        <div class="tools">
                                            <i class="fa fa-edit"></i>
                                            <i class="fa fa-trash-o"></i>
                                        </div>
                                    </li>
                                    <li>
                          <span class="handle">
                            <i class="fa fa-ellipsis-v"></i>
                            <i class="fa fa-ellipsis-v"></i>
                          </span>
                                        <input type="checkbox" value="">
                                        <span class="text">Limpiar utensilios</span>
                                        <small class="label label-success"><i class="fa fa-clock-o"></i> 1 dia</small>
                                        <div class="tools">
                                            <i class="fa fa-edit"></i>
                                            <i class="fa fa-trash-o"></i>
                                        </div>
                                    </li>
                                    <li>
                          <span class="handle">
                            <i class="fa fa-ellipsis-v"></i>
                            <i class="fa fa-ellipsis-v"></i>
                          </span>
                                        <input type="checkbox" value="">
                                        <span class="text">Buscar nuevos eventos</span>
                                        <small class="label label-primary"><i class="fa fa-clock-o"></i> 1 semana</small>
                                        <div class="tools">
                                            <i class="fa fa-edit"></i>
                                            <i class="fa fa-trash-o"></i>
                                        </div>
                                    </li>
                                    <li>
                          <span class="handle">
                            <i class="fa fa-ellipsis-v"></i>
                            <i class="fa fa-ellipsis-v"></i>
                          </span>
                                        <input type="checkbox" value="">
                                        <span class="text">Revisar papeleo</span>
                                        <small class="label label-default"><i class="fa fa-clock-o"></i> 1 mes</small>
                                        <div class="tools">
                                            <i class="fa fa-edit"></i>
                                            <i class="fa fa-trash-o"></i>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer clearfix no-border">
                                <button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Añadir tarea</button>
                            </div>
                        </div>

                        <!-- BAR CHART -->
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">Costes/Ingresos</h3>

                                <div class="box-tools pull-right">
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                    </button>
                                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <div class="box-body">
                                <div class="chart">
                                    <canvas id="barChart" style="height:230px"></canvas>
                                </div>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </section>

                    <section class="col-md-5">

                        <!-- PRODUCT LIST -->
                        <div class="box box-success">
                            <div class="box-header with-border">
                                <h3 class="box-title">Compras recientes</h3>

                                <div class="box-tools pull-right">
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                    </button>
                                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <ul class="products-list product-list-in-box">
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="<c:url value="/resources/dist/img/default-50x50.gif" />" alt="Product Image">
                                        </div>
                                        <div class="product-info">
                                            <a href="javascript:void(0)" class="product-title">Samsung TV
                                                <span class="label label-warning pull-right">$500</span></a>
                                            <span class="product-description">
                              Samsung 22" 1080p 60Hz LED Smart HDTV.
                            </span>
                                        </div>
                                    </li>
                                    <!-- /.item -->
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="<c:url value="/resources/dist/img/default-50x50.gif" />" alt="Product Image">
                                        </div>
                                        <div class="product-info">
                                            <a href="javascript:void(0)" class="product-title">Encimera - Electrolux EHF6232IOK
                                                <span class="label label-success pull-right">$200</span></a>
                                            <span class="product-description">
                              Vitrocerámica, 3 Fuegos, Sin Marco.
                            </span>
                                        </div>
                                    </li>
                                    <!-- /.item -->
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="<c:url value="/resources/dist/img/default-50x50.gif" />" alt="Product Image">
                                        </div>
                                        <div class="product-info">
                                            <a href="javascript:void(0)" class="product-title">Cafetera superautomática - Philips Saeco HD 8821/01
                                                <span class="label label-info pull-right">$299</span></a>
                                            <span class="product-description">
                              Función de memoria, Espumador de leche, Capacidad del depósito 1,8L.
                            </span>
                                        </div>
                                    </li>
                                    <!-- /.item -->
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="<c:url value="/resources/dist/img/default-50x50.gif" />" alt="Product Image">
                                        </div>
                                        <div class="product-info">
                                            <a href="javascript:void(0)" class="product-title">Frigorífico Americano - Samsung RS7527THCSL/EF
                                                <span class="label label-danger pull-right">$1035</span></a>
                                            <span class="product-description">
                              Inox, Clase A+, No frost, Display.
                            </span>
                                        </div>
                                    </li>
                                    <!-- /.item -->
                                </ul>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer text-center">
                                <a href="javascript:void(0)" class="uppercase">Mostrar todas las compras</a>
                            </div>
                            <!-- /.box-footer -->
                        </div>


                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Tipos de Eventos</h3>

                                <div class="box-tools pull-right">
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                    </button>
                                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="chart-responsive">
                                            <canvas id="pieChart" height="150"></canvas>
                                        </div>
                                        <!-- ./chart-responsive -->
                                    </div>
                                    <!-- /.col -->
                                    <div class="col-md-4">
                                        <ul class="chart-legend clearfix">
                                            <li><i class="fa fa-circle-o text-red"></i> Bodas</li>
                                            <li><i class="fa fa-circle-o text-green"></i> Bautizos</li>
                                            <li><i class="fa fa-circle-o text-yellow"></i> Fiestas</li>
                                            <li><i class="fa fa-circle-o text-aqua"></i> Concentraciones</li>
                                            <li><i class="fa fa-circle-o text-light-blue"></i> Refrescos</li>
                                            <li><i class="fa fa-circle-o text-gray"></i> Viajes </li>
                                        </ul>
                                    </div>
                                    <!-- /.col -->
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer no-padding">
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="#">Comunidad de Madrid
                                        <span class="pull-right text-red"><i class="fa fa-angle-down"></i> 52%</span></a></li>
                                    <li><a href="#">Segovia <span class="pull-right text-green"><i class="fa fa-angle-up"></i> 24%</span></a>
                                    </li>
                                    <li><a href="#">Los Molinos
                                        <span class="pull-right text-yellow"><i class="fa fa-angle-left"></i> 0%</span></a></li>
                                </ul>
                            </div>
                            <!-- /.footer -->
                        </div>
                        <!-- /.box -->
                    </section>
                    <!-- /.content -->
                </div>
            </section>
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
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>

    <!-- Morris.js charts -->
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="/plugins/morris/morris.min.js"></script> -->

    <!-- Sparkline -->
    <!--  <script src="/plugins/sparkline/jquery.sparkline.min.js"></script> -->

    <!-- jvectormap -->
    <!-- <script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script> -->

    <!-- jQuery Knob Chart -->
    <!-- <script src="/plugins/knob/jquery.knob.js"></script> -->

    <!-- Bootstrap WYSIHTML5 -->
    <!--  <script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script> -->

    <!-- ChartJS 1.0.1 -->
    <!-- <script src="/plugins/chartjs/Chart.min.js"></script> -->

    <!-- Script for Charts of "Gastos e ingresos" y "tipos de eventos" -->
    <script src="<c:url value="/resources/dist/js/scriptChartsFer.js" />"></script>


</body>
</html>