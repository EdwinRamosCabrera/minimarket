package com.market.minimarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NonNull
@NoArgsConstructor
@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra")
    private Integer idCompra;

    private LocalDateTime fecha;

    @Column(name="metodo_pago")
    private String metodoPago;

    private Double monto;

    private String comentario;

    private String estado;

    @Column(name="id_cliente")
    private Integer idCliente;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compraProducto", cascade = {CascadeType.ALL})
    private List<CompraProducto> ListCompraProducto;

}
