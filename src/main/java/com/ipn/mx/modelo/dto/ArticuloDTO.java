/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Articulo;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author JomianTC
 */
@Data
public class ArticuloDTO implements Serializable {

    private Articulo entidad;

    public ArticuloDTO() {

        entidad = new Articulo();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("idArticulo: ").append(getEntidad().getIdArticulo()).append("\n");
        sb.append("nombreArticulo: ").append(getEntidad().getNombreArticulo()).append("\n");
        sb.append("descripcionArticulo: ").append(getEntidad().getDescripcionArticulo()).append("\n");
        sb.append("existencias: ").append(getEntidad().getExistencias()).append("\n");
        sb.append("stockMinimo: ").append(getEntidad().getStockMinimo()).append("\n");
        sb.append("stockMaximo: ").append(getEntidad().getStockMaximo()).append("\n");
        sb.append("precio: ").append(getEntidad().getPrecio()).append("\n");
        sb.append("idCategoria: ").append(getEntidad().getIdCategoria()).append("\n");
        return sb.toString();
    }
}
