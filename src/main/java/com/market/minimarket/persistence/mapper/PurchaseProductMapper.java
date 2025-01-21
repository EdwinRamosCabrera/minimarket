package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.persistence.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseProductMapper {
    @Mappings({
            @Mapping(source="idCompraProducto", target="idPurchaseProduct"),
            @Mapping(source="idCompra", target="idPurchase"),
            @Mapping(source="idProducto", target="idProduct"),
            @Mapping(source="cantidad", target="quantity"),
            @Mapping(source="estado", target="status"),
    })
    PurchaseProduct toPurchaseProduct(CompraProducto compraProducto);

    List<PurchaseProduct> toListPurchaseProduct(List<CompraProducto> listCompraProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="compra", ignore=true),
    })
    CompraProducto toCompraProducto(PurchaseProduct purchaseProduct);
}
