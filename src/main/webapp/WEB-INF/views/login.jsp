<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
      <img src="<c:url value="/resources/dist/img/icono_transparente.png" />">
  </div>

  <div class="login-box-body">
    <p class="login-box-msg">Introduce email y contraseña</p>
    <springForm:form method="POST" id="formulario_Login" name='formulario_Login'  modelAttribute='userLog' action="../index.html">
      <div class="form-group has-feedback">
        <springForm:input path="email" cssClass="form-control" autofocus="true" placeholder="Email" type="email"/>
        <springForm:errors path="email" cssClass="alert-error" />
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <springForm:input path="password" cssClass="form-control" placeholder="Contraseña" type="password"/>
        <springForm:errors path="password" cssClass="alert-error" />
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <div class="row">
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Conectar</button>
        </div>
      </div>
    </springForm:form>

    <a href="usuarios/register" class="text-center">No estoy registado</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<%@ include file="../fragments/plugins.jspf" %>

</body>
</html>
