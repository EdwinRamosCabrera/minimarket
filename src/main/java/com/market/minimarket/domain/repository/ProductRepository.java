package com.market.minimarket.domain.repository;

import com.market.minimarket.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> getProduct(int idProduct);
    Product save(Product product);
    Product update(Product product);
    void delete(int idProduct);

    Optional<List<Product>> getProductByCategory(int idCategory);
    Optional<List<Product>> getAll();
    Optional<List<Product>> getScarseProduct(int quantity);
}
