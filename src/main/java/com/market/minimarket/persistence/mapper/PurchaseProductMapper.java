package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.persistence.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseMapper.class})
public interface PurchaseProductMapper {
    @Mappings({
            @Mapping(source="idCompraProducto", target="idPurchaseProduct"),
            @Mapping(source="idCompra", target="idPurchase"),
            @Mapping(source="idProducto", target="idProduct"),
            @Mapping(source="cantidad", target="quantity"),
            @Mapping(source="estado", target="status"),
            @Mapping(source="compra", target="purchase"),
    })
    PurchaseProduct toPurchaseProduct(CompraProducto compraProducto);

    List<PurchaseProduct> toListPurchaseProduct(List<CompraProducto> listCompraProducto);

    @InheritInverseConfiguration
    CompraProducto toCompraProducto(PurchaseProduct purchaseProduct);
}
