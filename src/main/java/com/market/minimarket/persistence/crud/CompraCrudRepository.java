package com.market.minimarket.persistence.crud;

import com.market.minimarket.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    List<Compra> findByMontoIsGreaterThan(Double monto);
}
