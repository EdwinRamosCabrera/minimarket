package com.market.minimarket.persistence.crud;

import com.market.minimarket.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {
    List<Cliente> findByFechaNacimientoAfter(Date fecha);
}
