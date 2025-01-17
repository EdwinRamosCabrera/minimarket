package com.market.minimarket.persistence.repository;

import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.domain.repository.PurchaseProductRepository;
import com.market.minimarket.persistence.crud.CompraProductoCrudRepository;
import com.market.minimarket.persistence.entity.CompraProducto;
import com.market.minimarket.persistence.mapper.PurchaseProductMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraProductoRepository implements PurchaseProductRepository {

    private CompraProductoCrudRepository compraProductoCrudRepository;
    private PurchaseProductMapper mapper;

    @Override
    public Optional<PurchaseProduct> getPurchaseProduct(int idPurchaseProduct) {
        return compraProductoCrudRepository.findById(idPurchaseProduct).map(item -> mapper.toPurchaseProduct(item));
    }
    @Override
    public PurchaseProduct save(PurchaseProduct purchaseProduct) {
        CompraProducto compraProducto = mapper.toCompraProducto(purchaseProduct);
        return mapper.toPurchaseProduct(compraProductoCrudRepository.save(compraProducto));
    }
    @Override
    public void delete(int idPurchaseProduct) {
        compraProductoCrudRepository.deleteById(idPurchaseProduct);
    }
    @Override
    public Optional<List<PurchaseProduct>> getAllPurchaseProduct() {
        List<CompraProducto> compraProductos = (List<CompraProducto>) compraProductoCrudRepository.findAll();
        return Optional.of(mapper.toListPurchaseProduct(compraProductos));
    }
}
