<%-- 
    Document   : listaDeArticulos
    Created on : 22/04/2022, 11:27:22 AM
    Author     : JomianTC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Articulos</title>
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
                            <a class="nav-link text-info" href="#">Listado de Articulos</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="mb-3"></div>
            <div class="card">
                <div class="card-header">
                    <h1 class="card-title text-info text-center">
                        Listado de Articulos
                    </h1>                    
                    <a href="ArticuloServlet?accion=nuevoA" class="btn btn-outline-primary">Nuevo</a>
                    <a href="ArticuloServlet?accion=graficarA" class="btn btn-outline-warning" target="_blank">Graficar</a>
                    <a href="ArticuloServlet?accion=verReporteA" class="btn btn-outline-info" target="_blank">Reporte</a>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <tr>
                            <th>Clave Articulo</th>
                            <th>Nombre Articulo</th>
                            <th>Descripcion Articulo</th>
                            <th>Existencias</th>
                            <th>StockMinimo</th>
                            <th>StockMaximo</th>
                            <th>Precio</th>
                            <th>Clave Categoria</th>
                            <th>Eliminar</th>
                            <th>Actualizar</th>
                        </tr>
                        <c:forEach items="${listado}" var="dto">
                            <tr>
                                <td>
                                    <a href="ArticuloServlet?accion=verA&id=${dto.entidad.idArticulo}" class="btn btn-outline-success">
                                        <c:out value="${dto.entidad.idArticulo}"/>
                                    </a>
                                </td>
                                <td><c:out value="${dto.entidad.nombreArticulo}"/></td>
                                <td><c:out value="${dto.entidad.descripcionArticulo}"/></td>
                                <td><c:out value="${dto.entidad.existencias}"/></td>
                                <td><c:out value="${dto.entidad.stockMinimo}"/></td>
                                <td><c:out value="${dto.entidad.stockMaximo}"/></td>
                                <td><c:out value="${dto.entidad.precio}"/></td>                                
                                <td><c:out value="${dto.entidad.idCategoria}"/></td>
                                <td><a href="ArticuloServlet?accion=eliminarA&id=${dto.entidad.idArticulo}" class="btn btn-outline-danger">Eliminar</a></td>
                                <td><a href="ArticuloServlet?accion=actualizarA&id=${dto.entidad.idArticulo}" class="btn btn-outline-info">Actualizar</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
