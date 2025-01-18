package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.entity.Purchase;
import com.market.minimarket.domain.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseService purchaseService;
    @GetMapping("{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable("id") int idPurchase){
        return purchaseService.getPurchase(idPurchase)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        try {
            return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Purchase> update(@PathVariable("id") int idPurchase, @RequestBody Purchase purchase){
        try {
            return new ResponseEntity<>(purchaseService.update(idPurchase, purchase), HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idPurchase){
        if(purchaseService.delete(idPurchase)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAllPurchase(){
        return purchaseService.getAllPurchase()
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/amount/{quantity}")
    public ResponseEntity<List<Purchase>> getByAmount(@PathVariable("quantity") double amount){
        return purchaseService.getByAmount(amount)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
