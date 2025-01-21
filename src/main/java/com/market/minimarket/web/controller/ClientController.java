package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Client;
import com.market.minimarket.domain.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            summary = "Muestra un cliente por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente encontrado correctamente"),
                    @ApiResponse(responseCode = "404", description = "cliente no encontrado")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") int idClient){
        return clientService.getClient(idClient)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Crea un nuevo cliente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "cliente creado correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo crear el cliente"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no puso ser completada"),
            }
    )
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
    @Operation(
            summary = "Modifica una cliente por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente modificado correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo modificar el cliente"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no pudo ser completada")
            }
    )
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
    @Operation(
            summary = "Elimina un cliente por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente encontrado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idClient){
        if(clientService.delete(idClient)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "Muestra todos los clientes",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Clientes encontrados correctamente"),
                    @ApiResponse(responseCode = "404", description = "Clientes no encontrados")
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient(){
        return clientService.getAllCliente()
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Muestra los cliente mayores una determinada edad",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Clientes encontrados correctamente"),
                    @ApiResponse(responseCode = "404", description = "Cliente no encontrados")
            }
    )
    @GetMapping("/age/{age}")
    public ResponseEntity<List<Client>> getClientOlderThan(@PathVariable("age") int age){
        LocalDate dateLimit = LocalDate.now().minusYears(age);
        return clientService.getByBirthdate(dateLimit)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
