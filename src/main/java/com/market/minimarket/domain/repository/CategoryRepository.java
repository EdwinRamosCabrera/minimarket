package com.market.minimarket.domain.repository;

import com.market.minimarket.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> getCategory(int idCategory);
    Category save(Category category);
    Category update(Category category);
    void delete(int idCategory);

    Optional<List<Category>> getAllCategory();
}
