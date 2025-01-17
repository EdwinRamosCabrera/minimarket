package com.market.minimarket.persistence.repository;

import com.market.minimarket.domain.entity.Supplier;
import com.market.minimarket.domain.repository.SupplierRepository;
import com.market.minimarket.persistence.crud.ProveedorCrudRepository;
import com.market.minimarket.persistence.entity.Proveedor;
import com.market.minimarket.persistence.mapper.SupplierMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ProveedorRepository implements SupplierRepository {

    private ProveedorCrudRepository proveedorCrudRepository;
    private SupplierMapper mapper;

    @Override
    public Optional<Supplier> getSupplier(int idSupplier) {
        Optional<Proveedor> proveedor = proveedorCrudRepository.findById(idSupplier);
        return proveedor.map(item -> mapper.toSupplier(item));
    }
    @Override
    public Supplier save(Supplier supplier) {
        Proveedor proveedor = mapper.toProveedor(supplier);
        return mapper.toSupplier(proveedorCrudRepository.save(proveedor));
    }
    @Override
    public void delete(int idSupplier) {
        proveedorCrudRepository.deleteById(idSupplier);
    }
    @Override
    public Optional<List<Supplier>> getAllSupplier() {
        List<Proveedor> proveedores = (List<Proveedor>) proveedorCrudRepository.findAll();
        return Optional.of(mapper.toSuppliers(proveedores));
    }
}
