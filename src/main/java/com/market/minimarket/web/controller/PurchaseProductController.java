package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.domain.service.PurchaseProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detail")
public class PurchaseProductController {

    private PurchaseProductService purchaseProductService;
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseProduct> getPurchaseProduct(@PathVariable("id") int idPurchaseProduct){
        return purchaseProductService.getPurchaseProduct(idPurchaseProduct)
                .map(purchaseProduct -> new ResponseEntity<>(purchaseProduct, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<PurchaseProduct> save(PurchaseProduct purchaseProduct){
        try {
            return new ResponseEntity<>(purchaseProductService.save(purchaseProduct), HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseProduct> update(@PathVariable("id") int idPurchaseProduct, @RequestBody PurchaseProduct purchaseProduct){
        try {
            return new ResponseEntity<>(purchaseProductService.update(idPurchaseProduct,purchaseProduct), HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idPurchaseProduct){
        if(purchaseProductService.delete(idPurchaseProduct)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all/")
    public ResponseEntity<List<PurchaseProduct>> getAllPurchaseProduct(){
        return purchaseProductService.getAllPurchaseProduct()
                .map(purchaseProduct -> new ResponseEntity<>(purchaseProduct, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
