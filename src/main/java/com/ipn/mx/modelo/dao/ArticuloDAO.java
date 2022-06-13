/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ArticuloDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JomianTC
 */
public class ArticuloDAO {

    private static final String SQL_INSERT = "{call spInsertarA( ?, ?, ?, ?, ?, ?, ?)}";
    private static final String SQL_UPDATE = "{call spActualizarA( ?, ?, ?, ?, ?, ?, ?, ?)}";
    private static final String SQL_DELETE = "{call spEliminarA(?)}";
    private static final String SQL_READ = "{call spSeleccionarUnoA(?)}";
    private static final String SQL_READ_ALL = "{call spSeleccionarTodoA()}";

    private Connection conexion;

    public Connection obtenerConexion() {

        String usuario = "jomian";
        String clave = "jomian";
        String url = "jdbc:mysql://localhost:3306/ProyectoBase4";
        String driverDB = "com.mysql.cj.jdbc.Driver";

        try {

            Class.forName(driverDB);
            conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexion;
    }

    public void create(ArticuloDTO dto) throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;

        try {

            cs = conexion.prepareCall(SQL_INSERT);
            cs.setString(1, dto.getEntidad().getNombreArticulo());
            cs.setString(2, dto.getEntidad().getDescripcionArticulo());
            cs.setInt(3, dto.getEntidad().getExistencias());
            cs.setInt(4, dto.getEntidad().getStockMinimo());
            cs.setInt(5, dto.getEntidad().getStockMaximo());
            cs.setDouble(6, dto.getEntidad().getPrecio());
            cs.setInt(7, dto.getEntidad().getIdCategoria());
            cs.executeUpdate();

        } finally {

            if (cs != null) {
                cs.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(ArticuloDTO dto) throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;

        try {

            cs = conexion.prepareCall(SQL_UPDATE);
            cs.setString(1, dto.getEntidad().getNombreArticulo());
            cs.setString(2, dto.getEntidad().getDescripcionArticulo());
            cs.setInt(3, dto.getEntidad().getExistencias());
            cs.setInt(4, dto.getEntidad().getStockMinimo());
            cs.setInt(5, dto.getEntidad().getStockMaximo());
            cs.setDouble(6, dto.getEntidad().getPrecio());
            cs.setInt(7, dto.getEntidad().getIdCategoria());
            cs.setInt(8, dto.getEntidad().getIdArticulo());
            cs.executeUpdate();

        } finally {

            if (cs != null) {
                cs.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(ArticuloDTO dto) throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;

        try {

            cs = conexion.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdArticulo());
            cs.executeUpdate();

        } finally {

            if (cs != null) {
                cs.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public ArticuloDTO read(ArticuloDTO dto) throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;

        try {

            cs = conexion.prepareCall(SQL_READ);
            cs.setInt(1, dto.getEntidad().getIdArticulo());
            rs = cs.executeQuery();

            List resultados = obtenerResultados(rs);

            if (!resultados.isEmpty()) {
                return (ArticuloDTO) resultados.get(0);

            } else {
                return null;
            }

        } finally {

            if (cs != null) {
                cs.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public List readAll() throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;

        try {

            cs = conexion.prepareCall(SQL_READ_ALL);
            rs = cs.executeQuery();

            List resultados = obtenerResultados(rs);

            if (!resultados.isEmpty()) {
                return resultados;

            } else {
                return null;
            }

        } finally {

            if (cs != null) {
                cs.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {

            ArticuloDTO dto = new ArticuloDTO();
            dto.getEntidad().setIdArticulo(rs.getInt("idArticulo"));
            dto.getEntidad().setNombreArticulo(rs.getString("nombreArticulo"));
            dto.getEntidad().setDescripcionArticulo(rs.getString("descripcionArticulo"));
            dto.getEntidad().setExistencias(rs.getInt("existencias"));
            dto.getEntidad().setStockMinimo(rs.getInt("stockMinimo"));
            dto.getEntidad().setStockMaximo(rs.getInt("stockMaximo"));
            dto.getEntidad().setPrecio(rs.getDouble("precio"));
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            resultados.add(dto);
        }

        return resultados;
    }

    /*
    //Herramienta de DEBUGG
    public static void main(String[] args) {

        ArticuloDAO dao = new ArticuloDAO();
        ArticuloDTO dto = new ArticuloDTO();

        dto.getEntidad().setIdArticulo(4);
        dto.getEntidad().setNombreArticulo("Potenciometro");
        dto.getEntidad().setDescripcionArticulo("Potenciometro de 10Ohm");
        dto.getEntidad().setExistencias(10000);
        dto.getEntidad().setStockMinimo(100);
        dto.getEntidad().setStockMaximo(1000000);
        dto.getEntidad().setPrecio(10.50);
        dto.getEntidad().setIdCategoria(3);

        try {
            //dao.create(dto);
            //dao.update(dto);
            dao.delete(dto);
            //System.out.println(dao.read(dto));
            //System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
}
