package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.repository.ProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public Optional<Product> getProduct(int idProduct){
        return productRepository.getProduct(idProduct);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public Product update(Product product){
        return productRepository.update(product);
    }
    public boolean delete(int idProduct){
        try {
            productRepository.delete(idProduct);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }
    public Optional<List<Product>> getProductByCategory(int idCategory){
        return productRepository.getProductByCategory(idCategory);
    }
    public Optional<List<Product>> getAllProduct(){
        return productRepository.getAllProduct();
    }
    public Optional<List<Product>> getScarseProduct(int quantity){
        return productRepository.getScarseProduct(quantity);
    }
}
