package com.market.minimarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String codigo;

    private String nombres;

    private String apellidos;

    private String genero;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
    private String telefono;

    private String direccion;

    private String email;

}
