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
public class Category {

    private int idCategory;

    private String name;

    private String status;

}
