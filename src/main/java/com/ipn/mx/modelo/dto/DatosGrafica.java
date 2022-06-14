/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author escom
 */
@Data
public class DatosGrafica implements Serializable {

    private int cantidad;
    private String nombre;

    public DatosGrafica() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //"select categoriaNombre, count (articulo.idArticulo) from categoria inner join articulo on categoria.idcategoria = articulo.idcategoria group by categoria.idcategoria"
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad: ").append(cantidad).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        return sb.toString();
    }
}
