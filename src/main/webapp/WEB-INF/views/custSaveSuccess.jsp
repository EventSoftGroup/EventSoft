<%--
  Created by IntelliJ IDEA.
  User: Rodrigo de Miguel
  Date: 08/05/2017
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>
<html>
<head>
    <title>Empleado Saved Successfully</title>
</head>
<body>
<h3>
    Empleado Saved Successfully.
</h3>

<strong>Nombre: </strong><c:out value="${empleado.nombre}"></c:out><br>
<strong>Apellidos: </strong><c:out value="${empleado.apellidos}"></c:out><br>
<strong>Email: </strong><c:out value="${empleado.email}"></c:out><br>
<strong>Telefono: </strong><c:out value="${empleado.telefono}"></c:out><br>
<strong>FechaNacimiento: </strong><fmt:formatDate value="${empleado.fechaNacimiento}" type="date" /><br>

</body>
</html>