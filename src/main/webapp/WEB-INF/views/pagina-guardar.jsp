<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <h2>Adding of a String into the session</h2>

    <p>Guardado en sesión: ${miNombre}</p>

    <form action="guarda-nombre.html" method="post">
        <table>
            <tr>
                <td>Que quieres recordar:</td>
                <td><input type="text" name="nombre" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Guardar"/></td>
                <td></td>
            </tr>
        </table>
    </form>
    <a href="${pageContext.request.contextPath}/">Main page</a>
    <a href="./muestra-sesion">Muestra sesion</a>
    <a href="./eliminar-sesion">Eliminar sesion</a>
</html>
