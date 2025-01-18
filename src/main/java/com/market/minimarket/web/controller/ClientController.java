package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Client;
import com.market.minimarket.domain.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") int idClient){
        return clientService.getClient(idClient)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<Client> save(@RequestBody Client client){
        try {
            return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable("id") int idClient, @RequestBody Client client){
        try {
            return new ResponseEntity<>(clientService.update(idClient, client), HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idClient){
        if(clientService.delete(idClient)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient(){
        return clientService.getAllCliente()
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/age/{age}")
    public ResponseEntity<List<Client>> getClientOlderThan(@PathVariable("age") int age){
        LocalDate dateLimit = LocalDate.now().minusYears(age);
        return clientService.getByBirthdate(dateLimit)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
