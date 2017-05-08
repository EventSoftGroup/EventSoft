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

<strong>Nombre: </strong>${empleado.nombre}<br>
<strong>Apellidos: </strong>${empleado.apellidos}<br>
<strong>Email: </strong>${empleado.email}<br>
<strong>Telefono: </strong>${empleado.telefono}<br>
<strong>FechaNacimiento: </strong><fmt:formatDate value="${empleado.fechaNacimiento}" type="date" /><br>

</body>
</html>