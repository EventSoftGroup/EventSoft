<%--
  Created by IntelliJ IDEA.
  User: Rodrigo de Miguel
  Date: 08/05/2017
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Save Page</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<springForm:form method="POST" modelAttribute="empleado"  action="save.do">
    <table>
        <tr>
            <td>Nombre:</td>
            <td><springForm:input path="nombre" /></td>
            <td><springForm:errors path="nombre" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Apellidos:</td>
            <td><springForm:input path="apellidos" /></td>
            <td><springForm:errors path="apellidos" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><springForm:input path="email" /></td>
            <td><springForm:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Fecha Nacimiento:</td>
            <td><springForm:input path="fechaNacimiento" placeholder="DD/MM/YY"/></td>
            <td><springForm:errors path="fechaNacimiento" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Teléfono:</td>
            <td><springForm:input path="telefono" /></td>
            <td><springForm:errors path="telefono" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Guardar Empleado"></td>
        </tr>
    </table>

</springForm:form>

</body>
</html>