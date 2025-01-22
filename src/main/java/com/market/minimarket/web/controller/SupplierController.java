package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Supplier;
import com.market.minimarket.domain.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }
    @Operation(
            summary = "Muestra un proveedor por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Proveedor encontrado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Proveedor no encontrado")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") int idSupplier){
        return supplierService.getSupplier(idSupplier)
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Crea un nuevo proveedor",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Proveedor creado correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo crear el proveedor"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no puso ser completada"),
            }
    )
    @PostMapping("/")
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier){
       return new ResponseEntity<>(supplierService.save(supplier),HttpStatus.CREATED);
    }
    @Operation(
            summary = "Modifica un proveedor por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Proveedor modificado correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo modificar el proveedor"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no pudo ser completada")
            }
    )
    @PutMapping("/{id}")
    public  ResponseEntity<Supplier> update(@PathVariable("id") int idSupplier, @RequestBody Supplier supplier){
        return new ResponseEntity<>(supplierService.update(idSupplier,supplier), HttpStatus.ACCEPTED);
    }
    @Operation(
            summary = "Elimina un proveedor por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Proveedor eliminado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Proveedor no encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idSupplier){
        if(supplierService.delete(idSupplier)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "Muestra todas los proveedores",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Proveedores encontrados correctamente"),
                    @ApiResponse(responseCode = "404", description = "Proveedores no encontrados")
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAllSupplier(){
        return supplierService.getAllSupplier()
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
