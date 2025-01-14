package com.market.minimarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NonNull
@NoArgsConstructor
@Entity
@Table(name="proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proveedor")
    private Integer idProveedor;

    private String nombre;

    private String direccion;

    private String email;

    private String telefono;

    private String estado;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> listProduct;
}
