package com.market.minimarket.domain.service;

import com.market.minimarket.domain.entity.Category;
import com.market.minimarket.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Optional<Category> getCategory(int idCategory){
        return categoryRepository.getCategory(idCategory);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }
    public Category update(Category category){
        return categoryRepository.update(category);
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
