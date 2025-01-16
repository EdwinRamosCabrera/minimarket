package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.Product;
import com.market.minimarket.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
        @Mapping(source="idProducto", target="idProduct"),
        @Mapping(source="nombre", target="name"),
        @Mapping(source="precioVenta", target="price"),
        @Mapping(source="cantidad", target="stock"),
        @Mapping(source="estado", target="status"),
        @Mapping(source="idCategoria", target="idCategory"),
        @Mapping(source="categoria", target="category"),
    })
    Product toProduct(Producto producto);

    List<Product> toListProducts(List<Producto> listProductos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
