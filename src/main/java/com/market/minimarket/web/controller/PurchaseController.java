package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.entity.Purchase;
import com.market.minimarket.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private final PurchaseService purchaseService;
    @Autowired
    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @Operation(
            summary = "Muestra una compra por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Compra encontrada correctamente"),
                    @ApiResponse(responseCode = "404", description = "Compra no encontrada")
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable("id") int idPurchase){
        return purchaseService.getPurchase(idPurchase)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Crea una nueva compra",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Compra creada correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo crear la compra"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no puso ser completada"),
            }
    )
    @PostMapping("/")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        try {
            return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(
            summary = "Modifica una compra por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Compra modificada correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo modificar la compra"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no pudo ser completada")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Purchase> update(@PathVariable("id") int idPurchase, @RequestBody Purchase purchase){
        try {
            return new ResponseEntity<>(purchaseService.update(idPurchase, purchase), HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(
            summary = "Elimina una compra por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Compra eliminada correctamente"),
                    @ApiResponse(responseCode = "404", description = "Compra no encontrada")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idPurchase){
        if(purchaseService.delete(idPurchase)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "Muestra todas las compras",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Compras encontradas correctamente"),
                    @ApiResponse(responseCode = "404", description = "Compras no encontradas")
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAllPurchase(){
        return purchaseService.getAllPurchase()
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Muestra todas las compras mayores a un determinado monto",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Compras encontradas correctamente"),
                    @ApiResponse(responseCode = "404", description = "Compras no encontradas")
            }
    )
    @GetMapping("/amount/{quantity}")
    public ResponseEntity<List<Purchase>> getByAmount(@PathVariable("quantity") double amount){
        return purchaseService.getByAmount(amount)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
