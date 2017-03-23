<%@ include file="../fragments/head.jspf" %>
<!-- Content Wrapper. Contains page content -->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@ include file="../fragments/header.jspf" %>
    <%@ include file="../fragments/left-side-column.jspf" %>
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
                <div class="col-lg-3 col-xs-6">
                    <!-- small box  PROVEEDORES-->
                    <div class="small-box bg-aqua">
                        <div class="inner">
                            <h3>99</h3>
                            <p>Num proveedores</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-add"></i>
                        </div>
                        <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box ORGANIZADORES-->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <h3>60</h3>
                            <p>Num organizadores</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-add"></i>
                        </div>
                        <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box USUARIOS-->
                    <div class="small-box bg-yellow">
                        <div class="inner">
                            <h3>90</h3>
                            <p>Num usuarios</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-add"></i>
                        </div>
                        <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box ECENTOS ACTUALES-->
                    <div class="small-box bg-red">
                        <div class="inner">
                            <h3>65</h3>
                            <p>Eventos actuales</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-stats-bars"></i>
                        </div>
                        <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                <!-- ./col -->
            </div>
            <!-- CONTADORES DE USUARIOS -->
            <!-- /.row -->
            <!-- AREA CHART: GRAFICO -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Evolución Usuarios</h3>
                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <div class="chart">
                        <canvas id="areaChart" style="height:250px"></canvas>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
            <!-- FIN AREA CHART-->
            <!-- /.box -->
            <div class="row">
                <div class="col-md-6">
                    <!-- TABLE: PEORES OPINIONES PROVEEDORES -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Peores Opiniones</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div class="table-responsive">
                                <table class="table no-margin">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Proveedor</th>
                                        <th>Valoraciones negativas</th>
                                        <th>Valoraciones positivas</th>
                                        <th>Ratio</th>
                                        <th>Contactar</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><a href="#infoProveed">#1534</a></td>
                                        <td>Florero web</td>
                                        <td><span class="label label-danger">90</span></td>
                                        <td><span class="label label-success">20</span></td>
                                        <td><span class="label label-danger">4,5</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="#infoProveed">#7136</a></td>
                                        <td>DJEjemplo</td>
                                        <td><span class="label label-danger">50</span></td>
                                        <td><span class="label label-success">25</span></td>
                                        <td><span class="label label-danger">2</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>

                                    <tr>
                                        <td><a href="#infoProveed">#1681</a></td>
                                        <td>Limpiadores</td>
                                        <td><span class="label label-danger">23</span></td>
                                        <td><span class="label label-success">17</span></td>
                                        <td><span class="label label-danger">1,35</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="#infoProveed">#1142</a></td>
                                        <td>Chofer</td>
                                        <td><span class="label label-danger">10</span></td>
                                        <td><span class="label label-success">9</span></td>
                                        <td><span class="label label-danger">1,1</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="#infoProveed">#3135</a></td>
                                        <td>Casamentero</td>
                                        <td><span class="label label-danger">37</span></td>
                                        <td><span class="label label-success">45</span></td>
                                        <td><span class="label label-success">0,82</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>s
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer clearfix">
                            <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">Refrescar</a>
                        </div>
                        <!-- /.box-footer -->
                    </div>
                    <!-- /.box -->

                </div>
                <!-- /.col -->

                <div class="col-md-6">
                    <!-- TABLE: MEJORES OPINIONES PROVEEDORES -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Mejores Opiniones</h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div class="table-responsive">
                                <table class="table no-margin">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Proveedor</th>
                                        <th>Valoraciones positivas</th>
                                        <th>Valoraciones negativas</th>
                                        <th>Ratio</th>
                                        <th>Contactar</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><a href="#infoProveed">#1534</a></td>
                                        <td>Proveed super bueno SA</td>
                                        <td><span class="label label-success">75</span></td>
                                        <td><span class="label label-danger">5</span></td>
                                        <td><span class="label label-success">15</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="#infoProveed">#7136</a></td>
                                        <td>Proveed bueno SL</td>
                                        <td><span class="label label-success">45</span></td>
                                        <td><span class="label label-danger">5</span></td>
                                        <td><span class="label label-success">9</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>

                                    <tr>
                                        <td><a href="#infoProveed">#1681</a></td>
                                        <td>Juanita la cantaoa</td>
                                        <td><span class="label label-success">37</span></td>
                                        <td><span class="label label-danger">6</span></td>
                                        <td><span class="label label-success">6,1</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="#infoProveed">#1142</a></td>
                                        <td>Fisioterapia</td>
                                        <td><span class="label label-success">50</span></td>
                                        <td><span class="label label-danger">10</span></td>
                                        <td><span class="label label-success">5</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="#infoProveed">#3135</a></td>
                                        <td>Bailarines</td>
                                        <td><span class="label label-success">45</span></td>
                                        <td><span class="label label-danger">20</span></td>
                                        <td><span class="label label-warning">2,5</td>
                                        <td><a href="/eventos/nuevo-mensaje" class="btn btn-primary btn-xs">Enviar mail</a></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer clearfix">
                            <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">Refrescar</a>
                        </div>
                        <!-- /.box-footer -->
                    </div>
                    <!-- /.box -->

                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->



            <!-- Input addon -->
            <div class="row">
                <div class="col-md-6">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title" id="infoProveed">Información proveedor</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>


                        <div class="box-body">
                            <div class="input-group">
                                <span class="input-group-addon">#</span>
                                <input type="text" class="form-control" placeholder="1534">
                                <br>
                                <!-- /.box -->
                            </div>
                            <hr>
                            <!-- CUERPO INFORMACION -->
                            <div class="box-body">
                                <strong><i class="fa fa-book margin-r-5"></i> Nombre</strong>
                                <p class="text-muted">
                                    Florista Web .SL
                                </p>
                                <hr>
                                <strong><i class="fa fa-map-marker margin-r-5"></i> Localización</strong>
                                <p class="text-muted">Malibu, California</p>
                                <hr>
                                <strong><i class="fa fa-pencil margin-r-5"></i> Servicios</strong>
                                <p>
                                    <span class="label label-info">Flores a domicilio</span>
                                    <span class="label label-info">Ramos</span>
                                    <span class="label label-info">Bodas</span>
                                    <span class="label label-info">Fiestas</span>
                                </p>
                                <hr>
                                <strong><i class="fa fa-bar-chart margin-r-5"></i> Valoraciones</strong>
                                <p>
                                    <span class="label label-success"><i class="fa fa-thumbs-up margin-r-5"></i>45</span>
                                    <span class="label label-danger"><i class="fa fa-thumbs-down margin-r-5"></i>7</span> -->
                                    <span class="label label-success"></i>Ratio: 45</span>
                                </p>
                                <hr>
                                <strong><i class="fa fa-file-text-o margin-r-5"></i> Descricpcion</strong>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
                                <hr>
                                <strong><i class="fa fa-file-text-o margin-r-5"></i> Opciones</strong>
                                <p>
                                    <button type="button" class="btn btn-primary" href="/eventos/nuevo-mensaje"> Enviar mail</button>
                                    <button type="button" class="btn btn-warning" > Modificar datos</button>
                                    <button type="button" class="btn btn-danger" > Eliminar </button>
                            </div>
                            <!-- /.box-body -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- FIN Input addon -->
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
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/dist/js/pages/dashboard.js"></script>



<!--

 ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 -->

<!-- page script -->

<!-- COPIAR AQUI SCRIPT DE CHARTS PARA LA GRAFICA-->
</body>
</html>