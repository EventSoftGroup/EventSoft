<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fragments/head.jspf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <img src="<c:url value="/resources/dist/img/icono_transparente.png" />" />
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">Rellene el formulario</p>

        <form method="post" id="tipoUsuario" name='tipoUsuario'
              action="${pageContext.request.contextPath}/usuarios/tipoUsuario" >

            <div class="row">
                <div class="col-xs-12">
                    <div class="form-group">
                        <label>Selecciona el rol</label>
                        <select name="seleccion" id="rol" class="form-control select2" style="width: 100%;">
                            <option selected="selected" value="cliente">Cliente</option>
                            <option value="organizador">Organizador</option>
                            <option value="proveedor">Proveedor</option>
                        </select>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Elegir</button>
                </div>
                <!-- /.col -->
            </div>

        </form>

        <a href="/" class="text-center">Si estoy registrado</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<%@ include file="../fragments/plugins.jspf" %>
<script src="<c:url value="/resources/dist/js/register.js" />"></script>
</body>
</html>
