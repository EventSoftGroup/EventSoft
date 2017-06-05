<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fragments/head.jspf" %>

<body class="hold-transition register-page">
<div class="">

    <!-- Main content -->
    <section class="content">

        <div class="error-page">

            <h1 class="headline text-red">500</h1>
            <h2 class="headline text-danger"><c:out value="${errorMsg}"></c:out></h2>
            <div class="error-content">
                <h3><i class="fa fa-warning text-red"></i> Oops! Ocurrió un error interno.</h3>
                <p>Estamos trabajando en arreglar el problema. Disculpe las molestias.
                    Volver al <a href="/">login</a>.
                </p>
            </div>
        </div>
        <!-- /.error-page -->

    </section>
    <!-- /.content -->
</div>

</body>
</html>
