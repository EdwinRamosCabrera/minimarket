package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int idProduct){
        return productService.getProduct(idProduct)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<Product> save(@RequestBody Product product){
        try{
            return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int idProduct, @RequestBody Product product){
        try{
            return new ResponseEntity<>(productService.update(idProduct, product), HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idProduct){
        if(productService.delete(idProduct)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductByIdCategory(@PathVariable("id") int idCategory){
        return productService.getProductByCategory(idCategory)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        return productService.getAllProduct()
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/scarse/{id}")
    public ResponseEntity<List<Product>> getScarseProduct(@PathVariable("id") int quantity){
        return productService.getScarseProduct(quantity)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
