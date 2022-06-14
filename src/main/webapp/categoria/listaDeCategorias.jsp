<%-- 
    Document   : listaDeCategorias
    Created on : 21/04/2022, 02:28:20 PM
    Author     : JomianTC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Categorias</title>
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
                            <a class="nav-link text-info" href="#">Listado de Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="ArticuloServlet?accion=listaDeArticulos">Listado de Articulos</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="mb-3"></div>
            <div class="card">
                <div class="card-header">
                    <h1 class="card-title text-info text-center">
                        Listado de Categorias
                    </h1>                    
                    <a href="CategoriaServlet?accion=nuevo" class="btn btn-outline-primary">Nuevo</a>
                    <a href="CategoriaServlet?accion=verReporte" class="btn btn-outline-info" target="_blank">Reporte</a>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <tr>
                            <th>Clave Categoria</th>
                            <th>Nombre Categoria</th>
                            <th>Descripcion Categoria</th>
                            <th>Eliminar</th>
                            <th>Actualizar</th>
                        </tr>
                        <c:forEach items="${listado}" var="dto">
                            <tr>
                                <td>
                                    <a href="CategoriaServlet?accion=ver&id=${dto.entidad.idCategoria}" class="btn btn-outline-success">
                                        <c:out value="${dto.entidad.idCategoria}"/>
                                    </a>
                                </td>
                                <td><c:out value="${dto.entidad.nombreCategoria}"/></td>
                                <td><c:out value="${dto.entidad.descripcionCategoria}"/></td>
                                <td><a href="CategoriaServlet?accion=eliminar&id=${dto.entidad.idCategoria}" class="btn btn-outline-danger">Eliminar</a></td>
                                <td><a href="CategoriaServlet?accion=actualizar&id=${dto.entidad.idCategoria}" class="btn btn-outline-info">Actualizar</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
