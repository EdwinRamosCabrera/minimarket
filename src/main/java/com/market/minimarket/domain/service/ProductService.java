package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProduct(int idProduct){
        return productRepository.getProduct(idProduct);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public Product update(int idProduct, Product productUpdate){
        return getProduct(idProduct).map(product -> {
            // product.setIdProduct(productUpdate.getIdProduct());
            product.setName(productUpdate.getName());
            product.setPrice(productUpdate.getPrice());
            product.setStatus(productUpdate.getStatus());
            product.setIdCategory(productUpdate.getIdCategory());
            product.setIdSupplier(productUpdate.getIdSupplier());
            return productRepository.save(product);
        }).orElseThrow(()-> new RuntimeException("Producto no encontrado con el Id: " + idProduct));
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
