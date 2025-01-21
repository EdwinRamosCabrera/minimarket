package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.domain.service.PurchaseProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detail")
public class PurchaseProductController {

    private PurchaseProductService purchaseProductService;

    @Operation(
            summary = "Muestra el detalle de una compra por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle de compra encontrado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Detalle de compra no encontrado")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseProduct> getPurchaseProduct(@PathVariable("id") int idPurchaseProduct){
        return purchaseProductService.getPurchaseProduct(idPurchaseProduct)
                .map(purchaseProduct -> new ResponseEntity<>(purchaseProduct, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Crea un nuevo detalle de compra",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle de compra creado correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo crear el detalle de compra"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no puso ser completada"),
            }
    )
    @PostMapping("/")
    public ResponseEntity<PurchaseProduct> save(PurchaseProduct purchaseProduct){
        try {
            return new ResponseEntity<>(purchaseProductService.save(purchaseProduct), HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(
            summary = "Modifica el detalle de compra por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle de compra modificado correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo modificar el detalle de compra"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no pudo ser completada")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseProduct> update(@PathVariable("id") int idPurchaseProduct, @RequestBody PurchaseProduct purchaseProduct){
        try {
            return new ResponseEntity<>(purchaseProductService.update(idPurchaseProduct,purchaseProduct), HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(
            summary = "Elimina el detalle de compra por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle de compra eliminado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Detalle de compra no encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idPurchaseProduct){
        if(purchaseProductService.delete(idPurchaseProduct)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "Muestra todas los detalle de compra",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalles de compra encontrados correctamente"),
                    @ApiResponse(responseCode = "404", description = "Detalles de compra no encontrados")
            }
    )
    @GetMapping("/all/")
    public ResponseEntity<List<PurchaseProduct>> getAllPurchaseProduct(){
        return purchaseProductService.getAllPurchaseProduct()
                .map(purchaseProduct -> new ResponseEntity<>(purchaseProduct, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
