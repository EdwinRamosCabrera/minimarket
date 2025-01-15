package com.market.minimarket.persistence.repository;

import com.market.minimarket.domain.entity.Category;
import com.market.minimarket.domain.repository.CategoryRepository;
import com.market.minimarket.persistence.crud.CategoriaCrudRepository;
import com.market.minimarket.persistence.entity.Categoria;
import com.market.minimarket.persistence.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    CategoriaCrudRepository categoriaCrudRepository;
    CategoryMapper mapper;
    @Override
    public Optional<Category> getCategory(int idCategory) {
        Optional<Categoria> categoria = categoriaCrudRepository.findById(idCategory);
        return categoria.map(item -> mapper.toCategory(item));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public void delete(int idCategory) {
        categoriaCrudRepository.deleteById(idCategory);
    }

    @Override
    public Optional<List<Category>> getAllCategory() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
        return Optional.of(mapper.toListCategorys(categorias)) ;
    }
}
