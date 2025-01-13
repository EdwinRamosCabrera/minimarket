package com.market.minimarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NonNull
@NoArgsConstructor
@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name="codigo_barra")
    private String codigoBarra;

    @Column(name="precio_venta")
    private Double precioVenta;

    private Integer cantidad;

    private String estado;

    @Column(name="id_categoria")
    private String idCategoria;

    @Column(name="id_proveedor")
    private String idProveedor;
}
