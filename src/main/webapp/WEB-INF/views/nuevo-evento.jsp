<%@ include file="../fragments/head.jspf" %>
    <section class="col-lg-6 connectedSortable">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Datos generales</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <form role="form">
                <!-- text input -->
                <div class="form-group">
                    <label>Nombre del evento</label>
                    <input type="text" class="form-control" placeholder="Boda de...">
                </div>
                <div class="form-group">
                    <label>Lugar del evento</label>
                    <input type="text" class="form-control" placeholder="Donde se van a desarrollar los hechos...">
                </div>

                <!-- textarea -->
                <div class="form-group">
                    <label>Descripción</label>
                    <textarea class="form-control" rows="3" placeholder="Una breve descripción del evento..."></textarea>
                </div>

                <!-- select -->
                <div class="form-group">
                    <label>Tipo de evento</label>
                    <select class="form-control">
                        <option>Boda</option>
                        <option>Despedida de solter@</option>
                        <option>Baby Shower</option>
                        <option>Comida empresa</option>
                    </select>
                </div>

            </form>
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
    <section class="col-lg-12 connectedSortable">
    <div class="box box-solid">
        <div class="box-header with-border">
            <h3 class="box-title">Proveedores</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <div class="box-group" id="accordion">
                <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                <div class="panel box box-success">
                    <div class="box-header with-border">
                        <h4 class="box-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                Floristas
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-lg-3 col-xs-6">
                                    <!-- small box -->
                                    <div class="small-box bg-green">
                                        <div class="inner">
                                            <h3>Flores Pili</h3>

                                            <p>Desde 1895</p>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            Elegir <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>
                                </div>
                                <!-- ./col -->
                                <div class="col-lg-3 col-xs-6">
                                    <!-- small box -->
                                    <div class="small-box bg-green">
                                        <div class="inner">
                                            <h3>Flores Paco</h3>

                                            <p>Siempre a tu lado.</p>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            Elegir <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel box box-warning">
                <div class="box-header with-border">
                    <h4 class="box-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                            Musica
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                    <div class="box-body">
                        <div class="row">
                            <div class="col-lg-3 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-yellow">
                                    <div class="inner">
                                        <h3>DJ Napo</h3>

                                        <p>La mejor música</p>
                                    </div>
                                    <a href="#" class="small-box-footer">
                                        Elegir <i class="fa fa-arrow-circle-right"></i>
                                    </a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-lg-3 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-yellow">
                                    <div class="inner">
                                        <h3>((Radical))</h3>

                                        <p>Remember</p>
                                    </div>
                                    <a href="#" class="small-box-footer">
                                        Elegir <i class="fa fa-arrow-circle-right"></i>
                                    </a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-lg-3 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-yellow">
                                    <div class="inner">
                                        <h3>Chasis</h3>

                                        <p>El poder de la música</p>
                                    </div>
                                    <a href="#" class="small-box-footer">
                                        Elegir <i class="fa fa-arrow-circle-right"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel box box-info">
                <div class="box-header with-border">
                    <h4 class="box-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                            Catering
                        </a>
                    </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse">
                    <div class="box-body">
                        <div class="row">
                            <div class="col-lg-3 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-aqua">
                                    <div class="inner">
                                        <h3>Bites</h3>

                                        <p>Novedades!</p>
                                    </div>
                                    <a href="#" class="small-box-footer">
                                        Elegir <i class="fa fa-arrow-circle-right"></i>
                                    </a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-lg-3 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-aqua">
                                    <div class="inner">
                                        <h3>Pans&Comp</h3>

                                        <p>Bocatas ricos</p>
                                    </div>
                                    <a href="#" class="small-box-footer">
                                        Elegir <i class="fa fa-arrow-circle-right"></i>
                                    </a>
                                </div>
                            </div>
                            <!-- ./col -->
                            <div class="col-lg-3 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-aqua">
                                    <div class="inner">
                                        <h3>Burger King</h3>

                                        <p>El sabor esta en el king</p>
                                    </div>
                                    <a href="#" class="small-box-footer">
                                        Elegir <i class="fa fa-arrow-circle-right"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.box-body -->
    </div>

    </div>
</section>
<%@ include file="../fragments/footer.jspf" %>