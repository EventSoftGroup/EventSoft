<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <h2>Adding of a String into the session</h2>

    <p>Guardado en sesión:</p>
    <p>Palabra1: ${palabra1}</p>
    <p>Palabra2: ${palabra2}</p>

    <form action="guarda-nombre.html" method="post">
        <table>
            <tr>
                <td>Que quieres recordar:</td>
                <td><input type="text" name="palabra1" /></td>
                <td><input type="text" name="palabra2" /></td>
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
