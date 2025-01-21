package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Category;
import com.market.minimarket.domain.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;
    @Operation(
            summary = "Muestra una categoría por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categoría encontrada correctamente"),
                    @ApiResponse(responseCode = "404", description = "Categoría no encontrada")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int idCategory){
        return categoryService.getCategory(idCategory)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(
            summary = "Crea una nueva categoría",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categoría creada correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo crear la categoría"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no pudo ser completada"),
            }
    )
    @PostMapping("/")
    public ResponseEntity<Category> save(@RequestBody Category category){
        try{
            return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(
            summary = "Modifica una categoría por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categoría modificada correctamente"),
                    @ApiResponse(responseCode = "409", description = "No se pudo modificar la categoría"),
                    @ApiResponse(responseCode = "500", description = "Hubo un error en el servidor y la solicitud no pudo ser completada")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") int id, @RequestBody Category category){
        try {
            return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.ACCEPTED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(
            summary = "Elimina una categoría por Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categoría eliminada correctamente"),
                    @ApiResponse(responseCode = "404", description = "Categoría no encontrada")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idCategory){
        if(categoryService.delete(idCategory)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "Muestra todas las categorías",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categorías encontradas correctamente"),
                    @ApiResponse(responseCode = "404", description = "Categorías no encontradas")
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory() {
        return categoryService.getAllCategory()
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
