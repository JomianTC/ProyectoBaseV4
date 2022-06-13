<%-- 
    Document   : verCategoria
    Created on : 21/04/2022, 04:57:56 PM
    Author     : JomianTC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de la Categoria</title>
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
                        Datos de la Categoria
                    </h1>
                </div>
                <div class="card-body">
                    <table class="table table-bordered border-info">
                        <tr class="text-info">
                            <td><strong>Clave de la Categoria: </strong> <c:out value="${categoria.entidad.idCategoria}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Nombre de la Categoria: </strong> <c:out value="${categoria.entidad.nombreCategoria}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Descripcion de la Categoria: </strong> <c:out value="${categoria.entidad.descripcionCategoria}"/></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
