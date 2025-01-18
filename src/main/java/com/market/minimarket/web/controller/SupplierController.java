package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Supplier;
import com.market.minimarket.domain.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierService supplierService;

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") int idSupplier){
        return supplierService.getSupplier(idSupplier)
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier){
       return new ResponseEntity<>(supplierService.save(supplier),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Supplier> update(@PathVariable("id") int idSupplier, @RequestBody Supplier supplier){
        return new ResponseEntity<>(supplierService.update(idSupplier,supplier), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idSupplier){
        if(supplierService.delete(idSupplier)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAllSupplier(){
        return supplierService.getAllSupplier()
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
