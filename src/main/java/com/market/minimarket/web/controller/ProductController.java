package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int idProduct){
        return productService.getProduct(idProduct);
    }
    @PostMapping("/")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable("id") int idProduct, @RequestBody Product product){
        return productService.update(idProduct, product);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idProduct){
        return productService.delete(idProduct);
    }
    @GetMapping("/category/{id}")
    public Optional<List<Product>> getProductByIdCategory(@PathVariable("id") int idCategory){
        return productService.getProductByCategory(idCategory);
    }
    @GetMapping("/all")
    public Optional<List<Product>> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/scarse/{id}")
    public Optional<List<Product>> getScarseProduct(@PathVariable("id") int quantity){
        return productService.getScarseProduct(quantity);
    }
}
