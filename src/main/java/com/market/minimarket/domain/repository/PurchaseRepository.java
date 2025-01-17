package com.market.minimarket.domain.repository;

import com.market.minimarket.domain.entity.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    Optional<Purchase> getPurchase(int idPurchase);
    Purchase save(Purchase purchase);
    void delete(int idPurchase);

    Optional<List<Purchase>> getAllPurchase();

    Optional<List<Purchase>> getByAmount(Double amount);
}
