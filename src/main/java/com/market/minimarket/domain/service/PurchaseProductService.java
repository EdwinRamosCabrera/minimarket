package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.domain.repository.PurchaseProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseProductService {

    private PurchaseProductRepository purchaseProductRepository;

    public Optional<PurchaseProduct> getPurchaseProduct(int idPurchaseProduct){
        return purchaseProductRepository.getPurchaseProduct(idPurchaseProduct);
    }
    public PurchaseProduct save(PurchaseProduct purchaseProduct){
        return purchaseProductRepository.save(purchaseProduct);
    }
    public PurchaseProduct update(int idPurchaseProduct, PurchaseProduct purchaseProductUpdate){
        return getPurchaseProduct(idPurchaseProduct).map(purchaseProduct -> {
            // purchaseProduct.setIdPurchaseProduct(purchaseProductUpdate.getIdPurchaseProduct());
            purchaseProduct.setIdPurchase(purchaseProductUpdate.getIdPurchase());
            purchaseProduct.setIdProduct(purchaseProductUpdate.getIdProduct());
            purchaseProduct.setQuantity(purchaseProductUpdate.getQuantity());
            purchaseProduct.setStatus(purchaseProductUpdate.getStatus());
            return purchaseProductRepository.save(purchaseProduct);
        }).orElseThrow(()->new RuntimeException("PurchaseProduct no fue encontrado con el Id: " + idPurchaseProduct));
    }
    public boolean delete(int idPurchaseProduct){
        if(getPurchaseProduct(idPurchaseProduct).isPresent()){
            purchaseProductRepository.delete(idPurchaseProduct);
            return true;
        }else {
            return false;
        }
    }
    public Optional<List<PurchaseProduct>> getAllPurchaseProduct(){
        return purchaseProductRepository.getAllPurchaseProduct();
    }
}
