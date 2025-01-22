package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.Client;
import com.market.minimarket.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    public Client save(Client client){
        return clientRepository.save(client);
    }
    public Client update(int idCliente, Client clientUpdate){
        return getClient(idCliente).map(client -> {
           // client.setIdClient(clientUpdate.getIdClient());
            client.setCode(clientUpdate.getCode());
            client.setName(clientUpdate.getName());
            client.setLastName(clientUpdate.getLastName());
            client.setGender(clientUpdate.getGender());
            client.setBirthdate(clientUpdate.getBirthdate());
            client.setPhone(clientUpdate.getPhone());
            client.setEmail(clientUpdate.getEmail());
            return clientRepository.save(client);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con Id: " + idCliente));
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
    public Optional<List<Client>> getByBirthdate(LocalDate date){
        return clientRepository.getByBirthdate(date);
    }
}
