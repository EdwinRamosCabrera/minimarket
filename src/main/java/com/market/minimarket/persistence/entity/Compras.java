package com.market.minimarket.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "compras")
public class Compras {

    @Id
    @Column(name="id_compra")
    private Integer idCompra;

    private Date fecha;

    @Column(name="metodo_pago")
    private String metodoPago;

    private String comentario;

    private String estado;

    @Column(name="id_cliente")
    private Integer idCliente;

}
