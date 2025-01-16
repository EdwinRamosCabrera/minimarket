package com.market.minimarket.domain.entity;

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
public class Client {

    private int idClient;

    private String code;

    private String name;

    private String lastName;

    private String gender;

    private Date birthdate;

    private String phone;

    private String email;

    private List<Purchase> listPurchase;
}
