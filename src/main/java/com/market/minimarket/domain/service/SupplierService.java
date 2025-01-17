package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.Supplier;
import com.market.minimarket.domain.repository.SupplierRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public Optional<Supplier> getSupplier(int idSupplier){
        return supplierRepository.getSupplier(idSupplier);
    }
    public Supplier save(Supplier supplier){
        return supplierRepository.save(supplier);
    }
    public  Supplier update(int idSupplier, Supplier supplierUpdate){
        return getSupplier(idSupplier).map(supplier -> {
            // supplier.setIdSupplier(supplierUpdate.getIdSupplier());
            supplier.setName((supplierUpdate.getName()));
            supplier.setEmail(supplierUpdate.getEmail());
            supplier.setPhone(supplierUpdate.getPhone());
            supplier.setAddress(supplierUpdate.getAddress());
            supplier.setStatus(supplierUpdate.getStatus());
            return supplierRepository.save(supplier);
        }).orElseThrow(()-> new RuntimeException("Supplier no se encontro con Id: " + idSupplier));
    }
    public boolean delete(int idSupplier){
        try{
            supplierRepository.delete(idSupplier);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }
    public Optional<List<Supplier>> getAllSupplier(){
        return supplierRepository.getAllSupplier();
    }
}
