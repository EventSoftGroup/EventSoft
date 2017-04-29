<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fragments/head.jspf" %>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <img src="../../dist/img/icono_transparente.png"/>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">Rellene el formulario</p>

        <form id="formulario_registro" name='formulario_registro' modelAttribute="Organizador" action="${pageContext.request.contextPath}/usuarios/registrar_cliente.html" method="post">
            <div class="row">
                <div class="col-xs-12">
                    <div class="form-group">
                        <label>Selecciona el rol</label>
                        <select name="seleccion" id="rol" class="form-control select2" style="width: 100%;">
                            <option selected="selected" value="Cliente">Cliente</option>
                            <option value="Organizador">Organizador</option>
                            <option value="Proveedor">Proveedor</option>
                        </select>
                    </div>
                </div>
            </div>
            <div id="form_cliente">
                <!-- Nombre -->
                <div class="form-group has-feedback">
                    <input id="nombre" type="text" class="form-control" placeholder="Nombre" name="nombre" autofocus/>
                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
                <!-- Apellidos -->
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" placeholder="Apellidos" name="apellidos">
                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
            </div>
            <div id="form_profesional">
                <!-- Nombre empresa -->
                <div class="form-group has-feedback">
                    <input id="empresa" type="text" class="form-control" placeholder="Nombre empresa" name="empresa">
                    <span class="glyphicon glyphicon-briefcase form-control-feedback"></span>
                </div>
                <!-- CIF -->
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" placeholder="CIF" name="cif">
                    <span class="glyphicon glyphicon-list-alt form-control-feedback"></span>
                </div>
            </div>
            <!-- Dirección -->
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Dirección" name="direccion">
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <!-- Localidad -->
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Localidad" name="localidad">
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <!-- Provincia -->
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Provincia" name="provincia">
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <!-- Código postal -->
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Código postal" name="codigoPostal">
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <!-- Teléfono -->
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Teléfono" name="telefono">
                <span class="glyphicon glyphicon-phone form-control-feedback"></span>
            </div>
            <!-- Email -->
            <div class="form-group has-feedback">
                <input type="email" class="form-control" placeholder="Email" name="mail">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <!-- Password -->
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Contraseña" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Repite contraseña">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Registrar</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <!--<div class="social-auth-links text-center">
          <p>- OR -</p>
          <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using
            Facebook</a>
          <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using
            Google+</a>
        </div>-->

        <a href="login.html" class="text-center">Si estoy registrado</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<%@ include file="../fragments/plugins.jspf" %>
<script src="/dist/js/register.js"></script>
</body>
</html>
