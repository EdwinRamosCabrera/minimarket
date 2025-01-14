package com.market.minimarket.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NonNull
@NoArgsConstructor
public class PurchaseProduct {

    private int idPurchaseProduct;

    private int idPurchase;

    private int idProduct;

    private int quantity;

    private String status;

    private Purchase purchase;
}
