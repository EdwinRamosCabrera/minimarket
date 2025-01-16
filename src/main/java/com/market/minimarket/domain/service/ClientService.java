package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.Client;
import com.market.minimarket.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    public Client save(Client client){
        return clientRepository.save(client);
    }
    public Client update(Client client){
        return clientRepository.update(client);
    }
    public boolean delete(int idClient){
        return getClient(idClient).map(client -> {
            clientRepository.delete(idClient);
            return true;
        }).orElse(false);
    }

    public Optional<List<Client>> getAllCliente(){
        return clientRepository.getAllCliente();
    }
    public Optional<List<Client>> getByBirthdate(Date date){
        return clientRepository.getByBirthdate(date);
    }
}
