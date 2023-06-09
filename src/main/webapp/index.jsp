<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Instituto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">


        <c:if test="${ not empty msnExito}">
            <div class="alert alert-success" role="alert">
                <c:out value="${msnExito}"/>
            </div>

        </c:if>

    <c:if test="${ not empty msnError}">
        <div class="alert alert-danger " role="alert">
            <c:out value="${msnError}"/>
        </div>

    </c:if>

<c:if test="${not empty listaA}">

<table class="table table-hover">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Fecha Nacimiento</th>
        <th>Curso</th>
        <th>Media</th>
        <th>Acciones</th>
    </tr>
    <!--Recorrido For Each de la tabla-->
    <c:forEach var="alum" items="${listaA}">
        <tr>
            <th><c:out value="${alum.id}"></c:out> </th>
            <td><c:out value="${alum.nombre}"></c:out> </td>
            <td><c:out value="${alum.fNacimiento}"></c:out> </td>
            <td><c:out value="${alum.curso}"></c:out> </td>
            <td><c:out value="${alum.media}"></c:out> </td>
            <td>
                <a href="Controlador?opcion=modificar&cod=<c:out value='${alum.id}'></c:out> " class="btn fs-6">&#128394;</a>
                <a href="Controlador?opcion=eliminar&cod=<c:out value='${alum.id}'></c:out> " class="btn fs-6"> &#128465;</a>
            </td>
        </tr>
    </c:forEach>
    </c:if>
</table>
</div>
</body>
</html>