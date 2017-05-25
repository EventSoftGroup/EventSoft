<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>


<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
      <img src="../../dist/img/icono_transparente.png"/>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Introduce email y contraseña</p>

    <!-- <form action="./index" method="post">-->
    <springForm:form method="POST" id="formulario_Login" name='formulario_Login'  modelAttribute='userLog' action="../index.html">
     <!-- <div class="form-group has-feedback">
        <input type="email" class="form-control" placeholder="Email" name="email" autofocus >
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Contraseña" name="pass">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>-->
      <div class="form-group has-feedback">
        <springForm:input path="email" cssClass="form-control" autofocus="true" placeholder="Email" type="email"/>
        <springForm:errors path="email" cssClass="alert-error" />
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <!-- Password -->
      <div class="form-group has-feedback">
        <springForm:input path="password" cssClass="form-control" placeholder="Contraseña" type="password"/>
        <springForm:errors path="password" cssClass="alert-error" />
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>



      <div class="row">
        <!--<div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Remember Me
            </label>
          </div>
        </div>-->
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Conectar</button>
        </div>
        <!-- /.col -->
      </div>
    </springForm:form>

    <!--<div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using
        Google+</a>
    </div>-->
    <!-- /.social-auth-links -->

    <!--<a href="#">I forgot my password</a><br>-->
    <a href="usuarios/register" class="text-center">No estoy registado</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<%@ include file="../fragments/plugins.jspf" %>

</body>
</html>
