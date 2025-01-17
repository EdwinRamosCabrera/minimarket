package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.domain.service.PurchaseProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detail")
public class PurchaseProductController {

    private PurchaseProductService purchaseProductService;
    @GetMapping("/{id}")
    public Optional<PurchaseProduct> getPurchaseProduct(@PathVariable("id") int idPurchaseProduct){
        return purchaseProductService.getPurchaseProduct(idPurchaseProduct);
    }
    @PostMapping("/")
    public PurchaseProduct save(PurchaseProduct purchaseProduct){
        return purchaseProductService.save(purchaseProduct);
    }
    @PutMapping("/{id}")
    public PurchaseProduct update(@PathVariable("id") int idPurchaseProduct, @RequestBody PurchaseProduct purchaseProduct){
        return purchaseProductService.update(idPurchaseProduct,purchaseProduct);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idPurchaseProduct){
        return purchaseProductService.delete(idPurchaseProduct);
    }
    @GetMapping("/all/")
    public Optional<List<PurchaseProduct>> getAllPurchaseProduct(){
        return purchaseProductService.getAllPurchaseProduct();
    }
}
