package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Operation(
            summary = "Muestra un producto por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto encontrado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int idProduct){
        return productService.getProduct(idProduct)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Crea un nuevo producto",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto creado correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo crear el producto"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no puso ser completada"),
            }
    )
    @PostMapping("/")
    public ResponseEntity<Product> save(@RequestBody Product product){
        try{
            return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(
            summary = "Modifica un producto por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto modificado correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo modificar el producto"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no pudo ser completada")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int idProduct, @RequestBody Product product){
        try{
            return new ResponseEntity<>(productService.update(idProduct, product), HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(
            summary = "Elimina un producto por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idProduct){
        if(productService.delete(idProduct)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "Muestra todas los productos por categoría",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Productos encontrados correctamente"),
                    @ApiResponse(responseCode = "404", description = "Productos no encontrados")
            }
    )
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductByIdCategory(@PathVariable("id") int idCategory){
        return productService.getProductByCategory(idCategory)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Muestra todas los productos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Productos encontrados correctamente"),
                    @ApiResponse(responseCode = "404", description = "Productos no encontrados")
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        return productService.getAllProduct()
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Muestra todos los productos escasos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Productos encontrados correctamente"),
                    @ApiResponse(responseCode = "404", description = "Productos no encontrados")
            }
    )
    @GetMapping("/scarse/{id}")
    public ResponseEntity<List<Product>> getScarseProduct(@PathVariable("id") int quantity){
        return productService.getScarseProduct(quantity)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
