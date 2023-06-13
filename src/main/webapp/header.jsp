<%--
  Created by IntelliJ IDEA.
  User: irime
  Date: 09/06/2023
  Time: 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand">Instituto de Alumnos</a>
    <ul class="nav nav-pills nav-fill">
      <li class="nav-item mx-4 px-4 ">
        <a class=" btn btn-outline-dark" aria-current="page" href="Controlador?opcion=listar&pagina=1">Listar</a>
      </li>
      <li class="nav-item mx-4 px-4">
        <a class="btn btn-outline-dark" href="alta.jsp">Nuevo Alumno</a>
      </li>
    </ul>
    <form class="d-flex" role="search" action="Controlador" method="post">
      <input type="hidden" name="opcion" value="buscar">
      <input type="hidden" name="pagina" value="1">

      <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search" name="nombreBusq">
      <select class="form-select" aria-label="Default select example" name="opcionBusq">
        <option selected>Buscar por</option>
        <option value="id">ID</option>
        <option value="nombre">Nombre</option>
        <option value="curso">Curso</option>
        <option value="media">Media</option>
      </select>


      <button class="btn btn-outline-dark" type="submit" name="search">Buscar</button>
    </form>
  </div>
</nav>
  </div>
</nav>
</body>
</html>
