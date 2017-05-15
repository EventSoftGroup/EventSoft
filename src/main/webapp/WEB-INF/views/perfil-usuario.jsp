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
                Perfil personal
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
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
                            <h3 class="profile-username text-center">${cliente.nombre} ${cliente.apellidos}</h3>
                            <!-- <p class="text-muted text-center">Florista Web</p>-->
                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b>Eventos</b> <a class="pull-right">45</a>
                                </li>
                                <li class="list-group-item">
                                    <b>Servicios Ofertados</b> <a class="pull-right">5</a>
                                </li>
                                <li class="list-group-item">
                                    <b>Tags</b>
                                    <br>
                                    <p>
                                        <span class="label label-info">Flores a domicilio</span>
                                        <span class="label label-info">Ramos</span>
                                        <span class="label label-info">Bodas</span>
                                        <span class="label label-info">Fiestas</span>
                                    </p>
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
                            <h3 class="box-title">About Me</h3>
                        </div>
                        <!-- /.box-header -->
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
                                <span class="label label-info">Arreglos florales</span>
                            </p>
                            <hr>
                            <strong><i class="fa fa-bar-chart margin-r-5"></i> Valoraciones</strong>
                            <p>
                                <span class="label label-success"><i class="fa fa-thumbs-up margin-r-5"></i>45</span>
                                <span class="label label-danger"><i class="fa fa-thumbs-down margin-r-5"></i>7</span>
                                -->
                                <span class="label label-success"></i>Ratio: 45</span>
                            </p>
                            <hr>
                            <strong><i class="fa fa-file-text-o margin-r-5"></i> Descricpcion</strong>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
                            <hr>
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
                            <li class="active"><a href="#activity" data-toggle="tab">Eventos Creados</a></li>
                            <li><a href="#timeline" data-toggle="tab">Valoraciones</a></li>
                            <li><a href="#settings" data-toggle="tab">Modificar Datos</a></li>
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
                            <div class="tab-pane" id="timeline">
                                <!-- The timeline -->
                                <div class="table-responsive mailbox-messages">
                                    <table class="table table-hover table-striped">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <input type="checkbox">
                                            </td>
                                            <td class="mailbox-star"><a href="#"><i
                                                    class="fa fa-thumbs-up text-green"></i></a></td>
                                            <td class="mailbox-name"><a href="/usuarios/perfil-Usuario">Alexander Pierce</a>
                                            </td>
                                            <td class="mailbox-subject"><b>Buen servicioIntegracionImp</b> - Muy buena presentación...
                                            </td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">hace 5 mins</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="checkbox">
                                            </td>
                                            <td class="mailbox-star"><a href="#"><i
                                                    class="fa fa-thumbs-up text-green"></i></a></td>
                                            <td class="mailbox-name"><a href="/usuarios/perfil-Usuario">Juana de Arco</a>
                                            </td>
                                            <td class="mailbox-subject"><b>No pudo ir mejor</b> - Me enamoré
                                                salvajemente...
                                            </td>
                                            <td class="mailbox-attachment">
                                                </i>
                                            </td>
                                            <td class="mailbox-date">hace 28 mins</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="checkbox">
                                            </td>
                                            <td class="mailbox-star"><a href="#"><i
                                                    class="fa fa-thumbs-up text-green"></i></a></td>
                                            <td class="mailbox-name"><a href="/usuarios/perfil-Usuario">Paquito el
                                                Chocolatero</a></td>
                                            <td class="mailbox-subject"><b>Diviiiinooo *.*</b> - Quiero casarme otra
                                                vez...
                                            </td>
                                            <td class="mailbox-attachment">
                                                </i>
                                            </td>
                                            <td class="mailbox-date">hace 11 horas</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="checkbox">
                                            </td>
                                            <td class="mailbox-star"><a href="#"><i
                                                    class="fa fa-thumbs-up text-green"></i></a></td>
                                            <td class="mailbox-name"><a href="/usuarios/perfil-Usuario">Java FTW</a></td>
                                            <td class="mailbox-subject"><b>Maravilloso</b> - Quién fuera flor para estar
                                                en tus manos...
                                            </td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">hace 15 horas</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="checkbox">
                                            </td>
                                            <td class="mailbox-star"><a href="#"><i
                                                    class="fa fa-thumbs-down text-red"></i></a></td>
                                            <td class="mailbox-name"><a href="/usuarios/perfil-Usuario">SOA Arquitecture</a>
                                            </td>
                                            <td class="mailbox-subject"><b>Mala calidad</b> - Las flores feisimas
                                                todas...
                                            </td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">Ayer</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="checkbox">
                                            </td>
                                            <td class="mailbox-star"><a href="#"><i
                                                    class="fa fa-thumbs-up text-green"></i></a></td>
                                            <td class="mailbox-name"><a href="/usuarios/perfil-Usuario">Aitor Tilla</a></td>
                                            <td class="mailbox-subject"><b>Fabuloso</b> - Me dan puntos por este
                                                comentario...
                                            </td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">hace 2 dias</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="checkbox">
                                            </td>
                                            <td class="mailbox-star"><a href="#"><i
                                                    class="fa fa-thumbs-down text-red"></i></a></td>
                                            <td class="mailbox-name"><a href="/usuarios/perfil-Usuario">Son Goku</a></td>
                                            <td class="mailbox-subject"><b>Malas flores</b> - Las flores del planeta
                                                Vegeta son mucho mejo...
                                            </td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">hace 2 dias</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <!-- /.table -->
                                </div>
                                <!-- /.mail-box-messages -->
                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="settings">
                                <form class="form-horizontal">
                                    <div class="form-group">
                                        <label for="inputName" class="col-sm-2 control-label">Name</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputName" placeholder="Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputEmail"
                                                   placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputName" class="col-sm-2 control-label">Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputName" placeholder="Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputExperience" class="col-sm-2 control-label">Experience</label>
                                        <div class="col-sm-10">
                                            <textarea class="form-control" id="inputExperience"
                                                      placeholder="Experience"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputSkills" class="col-sm-2 control-label">Skills</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="inputSkills"
                                                   placeholder="Skills">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> I agree to the <a href="#">terms and
                                                    conditions</a>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-danger">Submit</button>
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
