<%-- 
    Document   : articuloForm
    Created on : 22/04/2022, 12:12:18 PM
    Author     : JomianTC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Articulos</title>
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
                        Formulario para Datos del Articulo
                    </h1>
                </div>
                <div class="card-body">
                    <form method="post" action="ArticuloServlet?accion=guardarA">
                        <div class="mb-3">
                            <label for="txtIdA" class="form-label text-info">Clave del Articulo</label>
                            <input type="text" class="form-control" id="txtIdA" name="txtIdA"
                                   value="${dto.entidad.idArticulo}"
                                   placeholder="Clave del Articulo"/>
                        </div>
                        <div class="mb-3">
                            <label for="txtNombreA" class="form-label text-info">Nombre del Articulo</label>
                            <input type="text" class="form-control" id="txtNombreA" name="txtNombreA"
                                   value="${dto.entidad.nombreArticulo}"
                                   placeholder="Nombre del Articulo"
                                   required/>
                        </div>
                        <div class="mb-3">
                            <label for="txtDescripcionA" class="form-label text-info">Descripcion del Articulo</label>
                            <input type="text" class="form-control" id="txtDescripcionA" name="txtDescripcionA"
                                   value="${dto.entidad.descripcionArticulo}"
                                   placeholder="Descripcion del Articulo"
                                   required/>
                        </div>
                        <div class="mb-3">
                            <label for="txtExistenciasA" class="form-label text-info">Existencias</label>
                            <input type="text" class="form-control" id="txtExistenciasA" name="txtExistenciasA"
                                   value="${dto.entidad.existencias}"
                                   placeholder="Existencias"/>
                        </div>
                        <div class="mb-3">
                            <label for="txtStockMinimoA" class="form-label text-info">stock Minimo</label>
                            <input type="text" class="form-control" id="txtStockMinimoA" name="txtStockMinimoA"
                                   value="${dto.entidad.stockMinimo}"
                                   placeholder="stock Minimo"
                                   required/>
                        </div>
                        <div class="mb-3">
                            <label for="txtStockMaximoA" class="form-label text-info">stock Maximo</label>
                            <input type="text" class="form-control" id="txtStockMaximoA" name="txtStockMaximoA"
                                   value="${dto.entidad.stockMaximo}"
                                   placeholder="stock Maximo"
                                   required/>
                        </div>
                        <div class="mb-3">
                            <label for="txtPrecioA" class="form-label text-info">Clave del Articulo</label>
                            <input type="text" class="form-control" id="txtPrecioA" name="txtPrecioA"
                                   value="${dto.entidad.precio}"
                                   placeholder="Precio"/>
                        </div>
                        <div class="mb-3">
                            <label for="txtidCategoria" class="form-label text-info">Clave de la Categoria</label>
                            <input type="text" class="form-control" id="txtidCategoria" name="txtidCategoria"
                                   value="${dto.entidad.idCategoria}"
                                   placeholder="Clave de la Categoria"
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
