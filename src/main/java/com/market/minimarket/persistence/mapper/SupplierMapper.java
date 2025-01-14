package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.Supplier;
import com.market.minimarket.persistence.entity.Proveedor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mappings({
            @Mapping(source="idProveedor", target="idSupplier"),
            @Mapping(source="nombre", target="name"),
            @Mapping(source="telefono", target="phone"),
            @Mapping(source="direccion", target="address"),
            @Mapping(source="estado", target="status"),
            @Mapping(source="listProductos", target="listProducts")
    })
    Supplier toSupplier(Proveedor proveedor);

    @InheritInverseConfiguration
    Proveedor toProveedor(Supplier supplier);
}
