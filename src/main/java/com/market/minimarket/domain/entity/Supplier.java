package com.market.minimarket.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NonNull
@NoArgsConstructor
public class Supplier {

    private int idSupplier;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String status;

}
