package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.Purchase;
import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.domain.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    public Optional<Purchase> getPurchase(int idPurchase){
        return purchaseRepository.getPurchase(idPurchase);
    }
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
    public Purchase update(Purchase purchase){
        return purchaseRepository.update(purchase);
    }
    public boolean delete(int idPurchase){
        return getPurchase(idPurchase).map(purchase -> {
            purchaseRepository.delete(idPurchase);
            return true;
        }).orElse(false);
    }

    public Optional<List<Purchase>> getAllPurchase(){
        return purchaseRepository.getAllPurchase();
    }

    public Optional<List<Purchase>> getByAmount(Double amount){
        return purchaseRepository.getByAmount(amount);
    }
}
