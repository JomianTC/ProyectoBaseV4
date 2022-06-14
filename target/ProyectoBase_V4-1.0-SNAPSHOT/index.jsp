<%-- 
    Document   : index.jsp
    Created on : 21/04/2022, 02:41:48 PM
    Author     : JomianTC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link text-info" href="#">Home</a>
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
        </div>
        <div class="container">
            <h1 class="text-info text-center">Pagina Principal de la practica 4</h1>
            <img src="https://www.creadores.unam.mx/wp-content/uploads/2019/04/Escuela-Superior-de-Co%CC%81mputo-1280x720.jpg" class="container-fluid vh-100 d-flex flex-column align-items-center justify-content-center">
        </div>
    </body>
    <footer>
        <strong class="d-flex justify-content-center"><br>Derechos de Creacion</strong>
        <p class="d-flex justify-content-center">Torres Carrillo Josehf Miguel Angel</p>
    </footer>
</html>
