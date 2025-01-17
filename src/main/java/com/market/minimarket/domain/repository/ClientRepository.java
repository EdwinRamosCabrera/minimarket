package com.market.minimarket.domain.repository;

import com.market.minimarket.domain.entity.Client;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Optional<Client> getClient(int idClient);

    Client save(Client client);

    void delete(int idClient);

    Optional<List<Client>> getAllCliente();

    Optional<List<Client>> getByBirthdate(LocalDate date);
}
