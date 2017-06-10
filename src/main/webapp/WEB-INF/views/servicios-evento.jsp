<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                <c:if test="${not empty listaServicios}">
                    <small> <c:out value="${fn:length(listaServicios)}"></c:out> servicios</small>
                </c:if>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Inicio</a></li>
                <li class="active">Servicios ofertados</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <!-- /.col -->
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Servicios asociados al evento: <c:out value="${evento.nombre}"></c:out></h3>
                        </div>
                        <div class="box-body no-padding">
                            <div class="table-responsive mailbox-messages">
                                <c:set var="cantidad" scope="page" value="${listaServicios.size()}" />
                                <c:if test="${cantidad > 0}">
                                <table style="margin-top:2%;" class="table table-hover table-striped">
                                    <thead>
                                    <tr>
                                        <th class="text-center">Nombre</th>
                                        <th class="text-center">Descripción</th>
                                        <th class="text-center">Fecha de registro</th>
                                    </tr>
                                    </thead>

                                    <c:set var="count" value="1" scope="page" />
                                    <c:forEach var="servicio" items="${listaServicios}">
                                        <tr>
                                            <td class="mailbox-subject text-center"><c:out value="${servicio.getNombre()}"></c:out></td>
                                            <td class="mailbox-subject text-center"><b><c:out value="${servicio.getDescripcion()}"></c:out></b></td>
                                            <td class="mailbox-date text-center">
                                                <fmt:formatDate type = "date" value = "${servicio.getFechaRegistro()}" />
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>

                                </table>
                                </c:if>
                                <c:if test="${cantidad <= 0}">
                                    <b><p style="margin-left: 2%; font-size: 11pt;">*Servicio sin eventos asociados</p></b>
                                </c:if>

                            </div>

                        </div>
                    </div>
                    <!-- /. box -->
                </div>
                <!-- /.col -->

                <div class="table-responsive mailbox-messages">

                </div>
                <!-- /.mail-box-messages -->
            </div>
            <!-- /.box-body -->

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
<script src="<c:url value="/resources/dist/js/servicios.js" />"></script>
<!-- iCheck -->
<!-- Page Script -->
<script>
    $(function () {
        //Enable iCheck plugin for checkboxes
        //iCheck for checkbox and radio inputs
        /*$('.mailbox-messages input[type="checkbox"]').iCheck({
         checkboxClass: 'icheckbox_flat-blue',
         radioClass: 'iradio_flat-blue'
         });

         //Enable check and uncheck all functionality
         $(".checkbox-toggle").click(function () {
         var clicks = $(this).data('clicks');
         if (clicks) {
         //Uncheck all checkboxes
         $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
         $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
         } else {
         //Check all checkboxes
         $(".mailbox-messages input[type='checkbox']").iCheck("check");
         $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
         }
         $(this).data("clicks", !clicks);
         });*/

        //Handle starring for glyphicon and font awesome
        $(".mailbox-star").click(function (e) {
            e.preventDefault();
            //detect type
            var $this = $(this).find("a > i");
            var glyph = $this.hasClass("glyphicon");
            var fa = $this.hasClass("fa");

            //Switch states
            if (glyph) {
                $this.toggleClass("glyphicon-star");
                $this.toggleClass("glyphicon-star-empty");
            }

            if (fa) {
                $this.toggleClass("fa-star");
                $this.toggleClass("fa-star-o");
            }
        });
    });
</script>

</body>
</html>
