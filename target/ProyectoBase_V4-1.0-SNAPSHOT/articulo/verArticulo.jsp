<%-- 
    Document   : verArticulo
    Created on : 22/04/2022, 12:03:53 PM
    Author     : JomianTC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ver Articulo</title>
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
                        Datos del Articulo
                    </h1>
                </div>
                <div class="card-body">
                    <table class="table table-bordered border-info">
                        <tr class="text-info">
                            <td><strong>Clave del Articulo: </strong> <c:out value="${articulo.entidad.idArticulo}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Nombre del Articulo: </strong> <c:out value="${articulo.entidad.nombreArticulo}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Descripcion del Articulo: </strong> <c:out value="${articulo.entidad.descripcionArticulo}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Existencias del Articulo: </strong> <c:out value="${articulo.entidad.existencias}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Stock Minimo: </strong> <c:out value="${articulo.entidad.stockMinimo}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Stock Maximo: </strong> <c:out value="${articulo.entidad.stockMaximo}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Precio del Articulo: </strong> <c:out value="${articulo.entidad.precio}"/></td>
                        </tr>
                        <tr class="text-info">
                            <td><strong>Clave de la Categoria: </strong> <c:out value="${articulo.entidad.idCategoria}"/></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
