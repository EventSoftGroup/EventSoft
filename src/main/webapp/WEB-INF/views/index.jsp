<%@ include file="../fragments/head.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Content Wrapper. Contains page content -->
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <%@ include file="../fragments/header.jspf" %>
        <%@ include file="../fragments/left-side-column.jspf" %>
        <div class="content-wrapper">
            <h1>${message}</h1>
            <h2>Bienvenido a EventSoft</h2>
            <h2>Administración</h2>
        </div>

        <!-- footer -->
        <%@ include file="../fragments/footer.jspf" %>
        <!-- control-sidebar -->
        <%@ include file="../fragments/control-sidebar.jspf" %>


        <!-- Add the sidebar's background. This div must be placed
        immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>

    </div>
    <%@ include file="../fragments/plugins.jspf" %>
</body>
</html>
