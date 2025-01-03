package com.market.minimarket.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="categorias")
public class Categoria {

    @Id
    @Column(name="id_categoria")
    private String idCategoria;

    private String nombre;

    private String estado;

}
