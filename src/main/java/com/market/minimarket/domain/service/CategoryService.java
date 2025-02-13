package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.Category;
import com.market.minimarket.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> getCategory(int idCategory){
        return categoryRepository.getCategory(idCategory);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }
    public Category update(int idCategory, Category categoryUpdate){
        return getCategory(idCategory).map(category ->{
            // category.setIdCategory(categoryUpdate.getIdCategory());
            category.setName(categoryUpdate.getName());
            category.setStatus(categoryUpdate.getStatus());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + idCategory));
    }
    public boolean delete(int idCategory){
        if(getCategory(idCategory).isPresent()){
            categoryRepository.delete(idCategory);
            return true;
        }else {
            return false;
        }
    }
    public Optional<List<Category>> getAllCategory(){
        return categoryRepository.getAllCategory();
    }
}
