package com.market.minimarket.persistence.crud;

import com.market.minimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByIdCategoriaOrderByIdCategoria(int idCategoria);

    Optional<List<Producto>> findByCantidadIsLessThan(int cantidad);
}
