package com.market.minimarket.persistence.repository;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.repository.ProductRepository;
import com.market.minimarket.persistence.crud.ProductoCrudRepository;
import com.market.minimarket.persistence.entity.Producto;
import com.market.minimarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    ProductoCrudRepository productoCrudRepository;
    ProductMapper mapper;

    @Override
    public Optional<Product> getProduct(int idProduct) {
        Optional<Producto> producto = productoCrudRepository.findById(idProduct);
        return producto.map(item -> mapper.toProduct(item));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(int idProduct) {
        productoCrudRepository.deleteById(idProduct);
    }

    @Override
    public Optional<List<Product>> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return Optional.of(mapper.toListProducts(productos));
    }
    @Override
    public Optional<List<Product>> getProductByCategory(int idCategory) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByIdCategoria(idCategory);
        return Optional.of(mapper.toListProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        List<Producto> productos = productoCrudRepository.findByCantidadIsLessThan(quantity);
        return Optional.of(mapper.toListProducts(productos));
    }
}
