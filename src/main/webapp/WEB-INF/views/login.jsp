<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <img src="<c:url value="/resources/dist/img/icono_transparente.png" />">
    </div>

    <div class="login-box-body">
        <form method="post" action="/login">
            <h2 class="form-heading">ACCESO</h2>

            <span><c:out value="${message}"></c:out></span>
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <input type="email" name="username" class="form-control" placeholder="Email" value="" autofocus />
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <input type="password" name="password" class="form-control" placeholder="Contraseña" value="" />
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <span><c:out value="${error}"></c:out></span>
            <div class="form-group">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
                <h4 class="text-center"><a href="${contextPath}/usuarios/register">Crear cuenta</a></h4>
            </div>
        </form>
    </div>
</div>

<%@ include file="../fragments/plugins.jspf" %>

</body>
</html>
