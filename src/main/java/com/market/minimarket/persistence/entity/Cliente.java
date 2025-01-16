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
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer idCliente;

    private String codigo;

    private String nombres;

    private String apellidos;

    private String genero;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    private String telefono;

    private String correo;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> listCompras;

}
