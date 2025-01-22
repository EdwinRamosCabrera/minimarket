package com.market.minimarket.persistence.crud;

import com.market.minimarket.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer> {
}
