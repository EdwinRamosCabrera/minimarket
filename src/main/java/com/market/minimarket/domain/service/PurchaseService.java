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
    public Purchase update(int idPurchase, Purchase purchaseUpdate){
        return getPurchase(idPurchase).map(purchase ->{
            // purchase.setIdPurchase(purchaseUpdate.getIdPurchase());
            purchase.setDate(purchaseUpdate.getDate());
            purchase.setAmount(purchaseUpdate.getAmount());
            purchase.setComment(purchaseUpdate.getComment());
            purchase.setStatus(purchaseUpdate.getStatus());
            purchase.setClient(purchaseUpdate.getClient());
            return purchaseRepository.save(purchase);
        }).orElseThrow(()-> new RuntimeException("Purchase no encontrado con Id: " + idPurchase));
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
