package com.market.minimarket.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NonNull
@NoArgsConstructor
public class Product {

    private int idProduct;

    private String name;

    private double price;

    private int Stock;

    private String status;

    private int idCategory;

    private Category category;

    private int idSupplier;

    private Supplier supplier;

}
