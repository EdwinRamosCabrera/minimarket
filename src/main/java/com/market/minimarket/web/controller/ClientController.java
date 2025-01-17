package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Client;
import com.market.minimarket.domain.service.ClientService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int idClient){
        return clientService.getClient(idClient);
    }
    @PostMapping("/")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }
    @PutMapping("/{id}")
    public Client update(@PathVariable("id") int idClient, @RequestBody Client client){
        return clientService.update(idClient, client);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idClient){
        return clientService.delete(idClient);
    }
    @GetMapping("/all")
    Optional<List<Client>> getAllClient(){
        return clientService.getAllCliente();
    }
    @GetMapping("/age/{age}")
    Optional<List<Client>> getClientOlderThan(@PathVariable("age") int age){
        LocalDate dateLimit = LocalDate.now().minusYears(age);
        return clientService.getByBirthdate(dateLimit);
    }
}
