package com.market.minimarket.web.controller;

import com.market.minimarket.domain.entity.Category;
import com.market.minimarket.domain.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int idCategory){
        return categoryService.getCategory(idCategory);
    }
    @PostMapping("/")
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }
    @PutMapping("/{id}")
    public Category update(@PathVariable("id") int id, @RequestBody Category category){
        return categoryService.update(id, category);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idCategory){
        return categoryService.delete(idCategory);
    }
    @GetMapping("/all")
    public Optional<List<Category>> getAllCategory() {
        return categoryService.getAllCategory();
    }
}
