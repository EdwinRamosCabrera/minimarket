package com.market.minimarket.domain.repository;

import com.market.minimarket.domain.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository {

    Optional<Supplier> getSupplier(int idSupplier);
    Supplier save(Supplier supplier);
    Supplier update(Supplier supplier);
    void delete(int idSupplier);

    Optional<List<Supplier>> getAllSupplier();
}
