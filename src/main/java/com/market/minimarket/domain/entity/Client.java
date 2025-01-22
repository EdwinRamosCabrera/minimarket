package com.market.minimarket.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
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

    private LocalDate birthdate;

    private String phone;

    private String email;

}
