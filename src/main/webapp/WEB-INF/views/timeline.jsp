<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fragments/head.jspf" %>
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
        Timeline
        <small>example</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">UI</a></li>
        <li class="active">Timeline</li>
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
        <div class="box-body">
          <div class="col-md-4">
            <div class="form-group">
              <label>Selecciona el evento que quieras visualizar</label>
              <select id="eventos" class="form-control select2" style="width: 100%;">
                <option selected="selected">Evento 1</option>
                <option>Evento 2</option>
                <option>Evento 3</option>
                <option>Evento 4</option>
                <option>Evento 5</option>
                <option>Evento 6</option>
                <option>Evento 7</option>
              </select>
              <button id="aniadirServicio" class="btn btn-primary">Añadir un servicio</button>
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
              <option selected="selected">Categoria 1</option>
              <option>Categoria 2</option>
              <option>Categoria 3</option>
              <option>Categoria 4</option>
              <option>Categoria 5</option>
              <option>Categoria 6</option>
              <option>Categoria 7</option>
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
              <label>Selecciona los eventos que quieras incluir</label>
              <div id="demoform">
                <select multiple="multiple" size="10" name="mi_duallist[]">
                  <option value="option1">Option 1</option>
                  <option value="option2">Option 2</option>
                  <option value="option3" selected="selected">Option 3</option>
                  <option value="option4">Option 4</option>
                  <option value="option5">Option 5</option>
                  <option value="option6" selected="selected">Option 6</option>
                  <option value="option7">Option 7</option>
                  <option value="option8">Option 8</option>
                  <option value="option9">Option 9</option>
                  <option value="option0">Option 10</option>
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


      <!-- row -->
      <div class="row">
        <div class="col-md-12">
          <!-- The time line -->
          <ul class="timeline">
            <!-- timeline time label -->
            <li class="time-label">
                  <span class="bg-red">
                    10 Feb. 2014
                  </span>
            </li>
            <!-- /.timeline-label -->
            <!-- timeline item -->
            <li>
              <i class="fa fa-envelope bg-blue"></i>

              <div class="timeline-item">
                <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                <h3 class="timeline-header"><a href="#">Support Team</a> sent you an email</h3>

                <div class="timeline-body">
                  Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles,
                  weebly ning heekya handango imeem plugg dopplr jibjab, movity
                  jajah plickers sifteo edmodo ifttt zimbra. Babblely odeo kaboodle
                  quora plaxo ideeli hulu weebly balihoo...
                </div>
                <div class="timeline-footer">
                  <a class="btn btn-primary btn-xs">Read more</a>
                  <a class="btn btn-danger btn-xs">Delete</a>
                </div>
              </div>
            </li>
            <!-- END timeline item -->
            <!-- timeline item -->
            <li>
              <i class="fa fa-user bg-aqua"></i>

              <div class="timeline-item">
                <span class="time"><i class="fa fa-clock-o"></i> 5 mins ago</span>

                <h3 class="timeline-header no-border"><a href="#">Sarah Young</a> accepted your friend request</h3>
              </div>
            </li>
            <!-- END timeline item -->
            <!-- timeline item -->
            <li>
              <i class="fa fa-comments bg-yellow"></i>

              <div class="timeline-item">
                <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span>

                <h3 class="timeline-header"><a href="#">Jay White</a> commented on your post</h3>

                <div class="timeline-body">
                  Take me to your leader!
                  Switzerland is small and neutral!
                  We are more like Germany, ambitious and misunderstood!
                </div>
                <div class="timeline-footer">
                  <a class="btn btn-warning btn-flat btn-xs">View comment</a>
                </div>
              </div>
            </li>
            <!-- END timeline item -->
            <!-- timeline time label -->
            <li class="time-label">
                  <span class="bg-green">
                    3 Jan. 2014
                  </span>
            </li>
            <!-- /.timeline-label -->
            <!-- timeline item -->
            <li>
              <i class="fa fa-camera bg-purple"></i>

              <div class="timeline-item">
                <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>

                <h3 class="timeline-header"><a href="#">Mina Lee</a> uploaded new photos</h3>

                <div class="timeline-body">
                  <img src="http://placehold.it/150x100" alt="..." class="margin">
                  <img src="http://placehold.it/150x100" alt="..." class="margin">
                  <img src="http://placehold.it/150x100" alt="..." class="margin">
                  <img src="http://placehold.it/150x100" alt="..." class="margin">
                </div>
              </div>
            </li>
            <!-- END timeline item -->
            <!-- timeline item -->
            <li>
              <i class="fa fa-video-camera bg-maroon"></i>

              <div class="timeline-item">
                <span class="time"><i class="fa fa-clock-o"></i> 5 days ago</span>

                <h3 class="timeline-header"><a href="#">Mr. Doe</a> shared a video</h3>

                <div class="timeline-body">
                  <div class="embed-responsive embed-responsive-16by9">
                    <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/tMWkeBIohBs" frameborder="0" allowfullscreen></iframe>
                  </div>
                </div>
                <div class="timeline-footer">
                  <a href="#" class="btn btn-xs bg-maroon">See comments</a>
                </div>
              </div>
            </li>
            <!-- END timeline item -->
            <li>
              <i class="fa fa-clock-o bg-gray"></i>
            </li>
          </ul>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->


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
<script src="/dist/js/eventos.js"></script>
<script src="/dist/js/jquery.bootstrap-duallistbox.js"></script>
</body>
</html>
