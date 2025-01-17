package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.entity.Purchase;
import com.market.minimarket.domain.service.PurchaseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseService purchaseService;
    @GetMapping("{id}")
    public Optional<Purchase> getPurchase(@PathVariable("id") int idPurchase){
        return purchaseService.getPurchase(idPurchase);
    }
    @PostMapping("/")
    public Purchase save(@RequestBody Purchase purchase){
        return purchaseService.save(purchase);
    }
    @PutMapping("/{id}")
    public Purchase update(@PathVariable("id") int idPurchase, @RequestBody Purchase purchase){
        return purchaseService.update(idPurchase, purchase);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idPurchase){
        return purchaseService.delete(idPurchase);
    }
    @GetMapping("/all")
    public Optional<List<Purchase>> getAllPurchase(){
        return purchaseService.getAllPurchase();
    }
    @GetMapping("/amount/{quantity}")
    public Optional<List<Purchase>> getByAmount(@PathVariable("quantity") double amount){
        return purchaseService.getByAmount(amount);
    }
}
