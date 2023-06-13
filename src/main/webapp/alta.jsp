<%--
  Created by IntelliJ IDEA.
  User: irime
  Date: 07/06/2023
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
<head>
    <title>Instituto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
    <h4 class="text-center my-2">Alta de Alumnos</h4>

    <!--Enviamos el formulario que lo lea el Controller -->
    <form action="Controlador"  method="get" class="needs-validation" novalidate >

        <input type="hidden" name="opcion" value="alta">
        <input type="hidden" name="pagina" value="1">

         <div class="needs-validation" novalidate  >
        <div class="row">
        <div class="col-md-4">
            <label for="nombre" class="form-label">Nombre y Apellidos</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required maxlength="50"
           >
            <div class="invalid-feedback">
               Nombre requerido!
            </div>
        </div>
        <div class="col-md-2 ">
            <label for="curso" class="form-label">Curso</label>
            <input type="text" class="form-control" id="curso" name="curso" required maxlength="2"
                  >
            <div class="invalid-feedback">
                Curso requerido!
            </div>
        </div>
        <div class="col-md-2">
            <label for="fnac" class="form-label">Fecha Nacimiento</label>
            <input type="date" class="form-control" id="fnac" name="fnac" required
                   >
            <div class="invalid-feedback">
                Fecha de Nacimiento requerido!
            </div>
        </div>

        <div class="col-md-2">
            <label for="media" class="form-label">Media</label>
            <!-- Falta pattern-->
            <input type="number" class="form-control" id="media" name="media" required step="0.01" min="0" max="10"  >
            <div class="invalid-feedback"  >
                Media Requerida
            </div>
        </div>
        </div>
        <div class="row my-4">
        <div class="col-6 ">
            <button class="btn btn-primary" type="submit">Enviar Alta Nueva </button>
        </div>
            <div class="col-6 ">
            <a class="btn btn-primary" href="index.jsp">Cancelar </a>
        </div>
        </div>
    </div>

    </form>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (() => {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
    })()



</script>




</div>
</body>
</html>
