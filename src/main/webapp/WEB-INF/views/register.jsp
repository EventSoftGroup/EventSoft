<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fragments/head.jspf" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <img src="../../dist/img/icono_transparente.png"/>
    </div>

    <div class="register-box-body">
        <h2 class="login-box-msg">
            <c:choose>
                <c:when test="${tipoUsuario eq 'cliente'}">Cliente</c:when>
                <c:when test="${tipoUsuario eq 'organizador'}">Organizador</c:when>
                <c:when test="${tipoUsuario eq 'proveedor'}">Proveedor</c:when>
            </c:choose>
        </h2>
        <p class="login-box-msg">Rellene el formulario</p>

            <springForm:form method="POST" id="formulario_registro" name='formulario_registro'  modelAttribute='${tipoUsuario}' action="${pageContext.request.contextPath}/usuarios/registrar_${tipoUsuario}">

            <div id="form_especifico">
                <c:if test="${tipoUsuario eq 'cliente'}">
                    <div id="form_cliente">
                        <!-- Nombre -->
                        <div class="form-group has-feedback">
                            <springForm:input path="nombre" cssClass="form-control" autofocus="true" placeholder="Nombre" type="text" />
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            <springForm:errors path="nombre" cssClass="alert-error" />
                        </div>
                        <!-- Apellidos -->
                        <div class="form-group has-feedback">
                            <springForm:input path="apellidos" cssClass="form-control" autofocus="true" placeholder="Apellidos" type="text"/>
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            <springForm:errors path="apellidos" cssClass="alert-error" />

                        </div>
                    </div>
                </c:if>

                <c:if test="${(tipoUsuario eq 'organizador') or (tipoUsuario eq 'proveedor')}">
                    <div id="form_profesional">
                        <!-- Nombre empresa -->
                        <div class="form-group has-feedback">
                            <springForm:input path="empresa" cssClass="form-control" autofocus="true" placeholder="Nombre empresa" type="text"/>
                            <springForm:errors path="empresa" cssClass="alert-error" />
                            <span class="glyphicon glyphicon-briefcase form-control-feedback"></span>
                        </div>
                        <!-- CIF -->
                        <div class="form-group has-feedback">
                            <springForm:input path="CIF" cssClass="form-control" autofocus="true" placeholder="CIF" type="text"/>
                            <springForm:errors path="CIF" cssClass="alert-error" />
                            <span class="glyphicon glyphicon-list-alt form-control-feedback"></span>
                        </div>
                    </div>
                </c:if>
            </div>

            <!-- Dirección -->
            <div class="form-group has-feedback">
                <springForm:input path="direccion" cssClass="form-control" autofocus="true" placeholder="Dirección" type="text"/>
                <springForm:errors path="direccion" cssClass="alert-error" />
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <!-- Localidad -->
            <div class="form-group has-feedback">
                <springForm:input path="localidad" cssClass="form-control" autofocus="true" placeholder="Localidad" type="text"/>
                <springForm:errors path="localidad" cssClass="alert-error" />
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <!-- Provincia -->
            <div class="form-group has-feedback">
                <springForm:input path="provincia" cssClass="form-control" autofocus="true" placeholder="Provincia" type="text"/>
                <springForm:errors path="provincia" cssClass="alert-error" />
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <!-- Código postal -->
            <div class="form-group has-feedback">
                <springForm:input path="codigoPostal" cssClass="form-control" autofocus="true" placeholder="Código postal" type="text"/>
                <springForm:errors path="codigoPostal" cssClass="alert-error" />
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <!-- Teléfono -->
            <div class="form-group has-feedback">
                <springForm:input path="telefono" cssClass="form-control" autofocus="true" placeholder="Teléfono" type="text"/>
                <springForm:errors path="telefono" cssClass="alert-error" />
                <span class="glyphicon glyphicon-phone form-control-feedback"></span>
            </div>
            <!-- Email -->
            <div class="form-group has-feedback">
                <springForm:input path="email" cssClass="form-control" autofocus="true" placeholder="Email" type="email"/>
                <springForm:errors path="email" cssClass="alert-error" />
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <!-- Password -->
            <div class="form-group has-feedback">
                <springForm:input path="password" cssClass="form-control" autofocus="true" placeholder="Contraseña" type="password"/>
                <springForm:errors path="password" cssClass="alert-error" />
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <springForm:input path="" cssClass="form-control" autofocus="true" placeholder="Repite contraseña" type="password"/>
                <springForm:errors path="" cssClass="alert-error" />
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Registrar</button>
                </div>
                <!-- /.col -->
            </div>
        </springForm:form>

        <a href="../index.html" class="text-center">Si estoy registrado</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<%@ include file="../fragments/plugins.jspf" %>
<!-- <script src="/dist/js/register.js"></script> -->
</body>
</html>
