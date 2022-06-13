<%-- 
    Document   : categoriaForm
    Created on : 21/04/2022, 05:25:42 PM
    Author     : JomianTC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Categorias</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link text-info" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="CategoriaServlet?accion=listaDeCategorias">Listado de Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="ArticuloServlet?accion=listaDeArticulos">Listado de Articulos</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="mb-3"></div>
            <div class="card border-info">
                <div class="card-header">
                    <h1 class="card-title text-info text-center">
                        Formulario para Datos de la Categoria
                    </h1>
                </div>
                <div class="card-body">
                    <form method="post" action="CategoriaServlet?accion=guardar">
                        <div class="mb-3">
                            <label for="txtId" class="form-label text-info">Clave de la Categoria</label>
                            <input type="text" class="form-control" id="txtId" name="txtId"
                                   value="${dto.entidad.idCategoria}"
                                   placeholder="Clave de la Categoria"/>
                        </div>
                        <div class="mb-3">
                            <label for="txtNombre" class="form-label text-info">Nombre de la Categoria</label>
                            <input type="text" class="form-control" id="txtNombre" name="txtNombre"
                                   value="${dto.entidad.nombreCategoria}"
                                   placeholder="Nombre de la Categoria"
                                   required/>
                        </div>
                        <div class="mb-3">
                            <label for="txtDescripcion" class="form-label text-info">Descripcion de la Categoria</label>
                            <input type="text" class="form-control" id="txtDescripcion" name="txtDescripcion"
                                   value="${dto.entidad.descripcionCategoria}"
                                   placeholder="Descripcion de la Categoria"
                                   required/>
                        </div>
                        <div class="mb-3">
                            <input type="submit" id="btnEnviar" name="btnEnviar"
                                   class="btn btn-outline-info"
                                   value="Registrar"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
