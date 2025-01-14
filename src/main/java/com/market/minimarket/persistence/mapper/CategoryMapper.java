package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.Category;
import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.persistence.entity.Categoria;
import com.market.minimarket.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
        @Mapping(source="idCategoria", target="idCategory"),
        @Mapping(source="nombre", target="name"),
        @Mapping(source="estado", target="status"),
        @Mapping(source="listProductos", target="listProducts"),
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    Categoria toCategoria(Category category);
}
