package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.Supplier;
import com.market.minimarket.persistence.entity.Proveedor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mappings({
            @Mapping(source="idProveedor", target="idSupplier"),
            @Mapping(source="nombre", target="name"),
            @Mapping(source="telefono", target="phone"),
            @Mapping(source="direccion", target="address"),
            @Mapping(source="estado", target="status"),
    })
    Supplier toSupplier(Proveedor proveedor);

    List<Supplier> toSuppliers(List<Proveedor> listProveedores);

    @InheritInverseConfiguration
    @Mapping(target = "listProductos", ignore = true)
    Proveedor toProveedor(Supplier supplier);
}
