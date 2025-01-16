package com.market.minimarket.domain.repository;

import com.market.minimarket.domain.entity.PurchaseProduct;

import java.util.List;
import java.util.Optional;

public interface PurchaseProductRepository {

    Optional<PurchaseProduct> getPurchaseProduct(int idPurchaseProduct);
    PurchaseProduct save(PurchaseProduct purchaseProduct);
    PurchaseProduct update(PurchaseProduct purchaseProduct);
    void delete(int idPurchaseProduct);

    Optional<List<PurchaseProduct>> getAllPurchaseProduct();
}
