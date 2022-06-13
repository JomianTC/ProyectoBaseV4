/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
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
public class CategoriaDAO {

    private static final String SQL_INSERT = "{call spinsertarp(?, ?);}";
    private static final String SQL_UPDATE = "{call spactualizarrp(?, ?, ?);}";
    private static final String SQL_DELETE = "{call speliminarp(?);}";
    private static final String SQL_READ = "select * from categoria where idcategoria = ?;";
    private static final String SQL_READ_ALL = "select * from categoria;";

    private Connection conexion;

    public Connection obtenerConexion() {

        String usuario = "zfiqcmklzdgczr";
        String clave = "289ecded42b6283e4ff5692adab12b91c19a83b8b91e08fdf69784574fc88f77";
        String url = "jdbc:postgresql://ec2-54-157-16-196.compute-1.amazonaws.com/d6mrhnmu5dc0ah";
        String driverDB = "org.postgresql.Driver";

        try {

            Class.forName(driverDB);
            conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexion;
    }

    public void create(CategoriaDTO dto) throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;

        try {

            cs = conexion.prepareCall(SQL_INSERT);
            cs.setString(1, dto.getEntidad().getNombreCategoria());
            cs.setString(2, dto.getEntidad().getDescripcionCategoria());
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

    public void update(CategoriaDTO dto) throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;

        try {

            cs = conexion.prepareCall(SQL_UPDATE);
            cs.setString(1, dto.getEntidad().getNombreCategoria());
            cs.setString(2, dto.getEntidad().getDescripcionCategoria());
            cs.setInt(3, dto.getEntidad().getIdCategoria());
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

    public void delete(CategoriaDTO dto) throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;

        try {

            cs = conexion.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdCategoria());
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

    public CategoriaDTO read(CategoriaDTO dto) throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;

        try {

            cs = conexion.prepareCall(SQL_READ);
            cs.setInt(1, dto.getEntidad().getIdCategoria());
            rs = cs.executeQuery();

            List resultados = obtenerResultados(rs);

            if (!resultados.isEmpty()) {
                return (CategoriaDTO) resultados.get(0);

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

            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcionCategoria"));
            resultados.add(dto);
        }

        return resultados;
    }

    /*
    //Herramienta de DEBUGG

    public static void main(String[] args) {

        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();

        dto.getEntidad().setIdCategoria(5);
        dto.getEntidad().setNombreCategoria("Redes");
        dto.getEntidad().setDescripcionCategoria("Articulos De Redes");

        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
}
