package com.market.minimarket.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @Column(name="id_producto")
    private String idProducto;

    private String nombre;

    @Column(name="codigo_barra")
    private String codigoBarra;

    @Column(name="precio_venta")
    private Double precioVenta;


    private Integer cantidad;

    private String proveedor;

    private String estado;

    @Column(name="id_categoria")
    private String idCategoria;
}
