package com.market.minimarket.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NonNull
@NoArgsConstructor
public class Purchase {

    private int idPurchase;

    private LocalDateTime date;

    private String paymentMethod;

    private String comment;

    private String status;

    private int idClient;

    private Client client;

    private List<PurchaseProduct> listPurchaseProduct;
}
