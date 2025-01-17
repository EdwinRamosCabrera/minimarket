package com.market.minimarket.persistence.repository;

import com.market.minimarket.domain.entity.Purchase;
import com.market.minimarket.domain.repository.PurchaseRepository;
import com.market.minimarket.persistence.crud.CompraCrudRepository;
import com.market.minimarket.persistence.entity.Compra;
import com.market.minimarket.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private CompraCrudRepository compraCrudRepository;
    private PurchaseMapper mapper;

    @Override
    public Optional<Purchase> getPurchase(int idPurchase) {
        Optional<Compra> compra = compraCrudRepository.findById(idPurchase);
        return compra.map(item -> mapper.toPurchase(item));
    }
    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
    @Override
    public void delete(int idPurchase) {
        compraCrudRepository.deleteById(idPurchase);
    }

    @Override
    public Optional<List<Purchase>> getAllPurchase() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return Optional.of(mapper.toListPurchases(compras));
    }
    @Override
    public Optional<List<Purchase>> getByAmount(Double amount) {
        List<Compra> compras = compraCrudRepository.findByMontoIsGreaterThan(amount);
        return Optional.of(mapper.toListPurchases(compras));
    }
}
