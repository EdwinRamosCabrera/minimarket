package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Supplier;
import com.market.minimarket.domain.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierService supplierService;

    @GetMapping("/{id}")
    public Optional<Supplier> getSupplier(@PathVariable("id") int idSupplier){
        return supplierService.getSupplier(idSupplier);
    }
    @PostMapping("/")
    public Supplier save(@RequestBody Supplier supplier){
       return supplierService.save(supplier);
    }
    @PutMapping("/{id}")
    public  Supplier update(@PathVariable("id") int idSupplier, @RequestBody Supplier supplier){
        return supplierService.update(idSupplier,supplier);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idSupplier){
        return supplierService.delete(idSupplier);
    }
    @GetMapping("/all")
    public Optional<List<Supplier>> getAllSupplier(){
        return supplierService.getAllSupplier();
    }
}
