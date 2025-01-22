package com.market.minimarket.persistence.repository;

import com.market.minimarket.domain.entity.Client;
import com.market.minimarket.domain.repository.ClientRepository;
import com.market.minimarket.persistence.crud.ClienteCrudRepository;
import com.market.minimarket.persistence.entity.Cliente;
import com.market.minimarket.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private ClientMapper mapper;

    @Override
    public Optional<Client> getClient(int idClient) {
        Optional<Cliente> cliente = clienteCrudRepository.findById(idClient);
        return cliente.map(item -> mapper.toclient(item));
    }
    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toclient(clienteCrudRepository.save(cliente));
    }
    @Override
    public void delete(int idClient) {
        clienteCrudRepository.deleteById(idClient);
    }
    @Override
    public Optional<List<Client>> getAllCliente() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return Optional.of(mapper.toListClients(clientes));
    }
    @Override
    public Optional<List<Client>> getByBirthdate(LocalDate date) {
        List<Cliente> clientes = clienteCrudRepository.findByFechaNacimientoAfter(date);
        return Optional.of(mapper.toListClients(clientes));
    }
}
