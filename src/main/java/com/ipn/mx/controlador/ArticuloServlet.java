/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.ArticuloDAO;
import com.ipn.mx.modelo.dto.ArticuloDTO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author JomianTC
 */
@WebServlet(name = "ArticuloServlet", value = "/ArticuloServlet")
public class ArticuloServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        
        String accion = request.getParameter("accion");
        
        if (accion.equals("listaDeArticulos")) {
            listadoArticulo(request, response);
        } else {
            if (accion.equals("nuevoA")) {
                crearArticulo(request, response);
            } else {
                if (accion.equals("actualizarA")) {
                    actualizarArticulo(request, response);
                } else {
                    if (accion.equals("eliminarA")) {
                        eliminarArticulo(request, response);
                    } else {
                        if (accion.equals("guardarA")) {
                            almacenarArticulo(request, response);
                        } else {
                            if (accion.equals("verA")) {
                                mostrarArticulo(request, response);
                            } else {
                                if (accion.equals("verReporteA")) {
                                    mostrarReporte(request, response);
                                } else {
                                    if (accion.equals("graficarA")) {
                                        mostrarGrafica(request, response);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /*

        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CategoriaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoriaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

         */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listadoArticulo(HttpServletRequest request, HttpServletResponse response) {
        ArticuloDAO dao = new ArticuloDAO();
        
        try {
            List lista = dao.readAll();
            request.setAttribute("listado", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/articulo/listaDeArticulos.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ArticuloServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void crearArticulo(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("/articulo/articuloForm.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ArticuloServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void actualizarArticulo(HttpServletRequest request, HttpServletResponse response) {
        ArticuloDAO dao = new ArticuloDAO();
        ArticuloDTO dto = new ArticuloDTO();
        
        dto.getEntidad().setIdArticulo(Integer.parseInt(request.getParameter("id")));
        
        try {
            dto = dao.read(dto);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("/articulo/articuloForm.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ArticuloServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void eliminarArticulo(HttpServletRequest request, HttpServletResponse response) {
        ArticuloDAO dao = new ArticuloDAO();
        ArticuloDTO dto = new ArticuloDTO();
        
        dto.getEntidad().setIdArticulo(Integer.parseInt(request.getParameter("id")));
        
        try {
            dao.delete(dto);
            listadoArticulo(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void almacenarArticulo(HttpServletRequest request, HttpServletResponse response) {
        ArticuloDAO dao = new ArticuloDAO();
        ArticuloDTO dto = new ArticuloDTO();
        
        if (request.getParameter("txtIdA").isEmpty()) {
            
            dto.getEntidad().setNombreArticulo(request.getParameter("txtNombreA"));
            dto.getEntidad().setDescripcionArticulo(request.getParameter("txtDescripcionA"));
            dto.getEntidad().setExistencias(Integer.parseInt(request.getParameter("txtExistenciasA")));
            dto.getEntidad().setStockMinimo(Integer.parseInt(request.getParameter("txtStockMinimoA")));
            dto.getEntidad().setStockMaximo(Integer.parseInt(request.getParameter("txtStockMaximoA")));
            dto.getEntidad().setPrecio(Double.parseDouble(request.getParameter("txtPrecioA")));
            dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("txtidCategoria")));
            
            try {
                dao.create(dto);
                listadoArticulo(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            dto.getEntidad().setIdArticulo(Integer.parseInt(request.getParameter("txtIdA")));
            dto.getEntidad().setNombreArticulo(request.getParameter("txtNombreA"));
            dto.getEntidad().setDescripcionArticulo(request.getParameter("txtDescripcionA"));
            dto.getEntidad().setExistencias(Integer.parseInt(request.getParameter("txtExistenciasA")));
            dto.getEntidad().setStockMinimo(Integer.parseInt(request.getParameter("txtStockMinimoA")));
            dto.getEntidad().setStockMaximo(Integer.parseInt(request.getParameter("txtStockMaximoA")));
            dto.getEntidad().setPrecio(Double.parseDouble(request.getParameter("txtPrecioA")));
            dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("txtidCategoria")));
            
            try {
                dao.update(dto);
                listadoArticulo(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private void mostrarArticulo(HttpServletRequest request, HttpServletResponse response) {
        ArticuloDAO dao = new ArticuloDAO();
        ArticuloDTO dto = new ArticuloDTO();
        
        dto.getEntidad().setIdArticulo(Integer.parseInt(request.getParameter("id")));
        
        try {
            dto = dao.read(dto);
            request.setAttribute("articulo", dto);
            RequestDispatcher rd = request.getRequestDispatcher("/articulo/verArticulo.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ArticuloServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrarReporte(HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream sos = null;

        try {
            ArticuloDAO dao = new ArticuloDAO();
            sos = response.getOutputStream();
            File reporte;
            byte[] b;

            reporte = new File(getServletConfig().getServletContext().getRealPath("/reportes/ReportePostgressArticulo.jasper"));

            b = JasperRunManager.runReportToPdf(reporte.getPath(), null, dao.obtenerConexion());

            response.setContentType("application/pdf");
            response.setContentLength(b.length);
            sos.write(b, 0, b.length);
            sos.flush();
            sos.close();
        } catch (IOException | JRException ex) {
            Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                sos.close();
            } catch (IOException ex) {
                Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void mostrarGrafica(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
