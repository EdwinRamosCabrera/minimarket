package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.Purchase;
import com.market.minimarket.domain.entity.PurchaseProduct;
import com.market.minimarket.persistence.entity.Compra;
import com.market.minimarket.persistence.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, PurchaseProductMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source="idCompra", target="idPurchase"),
            @Mapping(source="fecha", target="date"),
            @Mapping(source="metodoPago", target="paymentMethod"),
            @Mapping(source="monto", target="amount"),
            @Mapping(source="comentario", target="comment"),
            @Mapping(source="estado", target="status"),
            @Mapping(source="idCliente", target="idClient"),
            @Mapping(source="cliente", target="client"),
            @Mapping(source="listCompraProducto", target="listPurchaseProduct"),
    })
    Purchase toPurchase(Compra compra);

    List<Purchase> toListPurchases(List<Compra> listCompras);

    @InheritInverseConfiguration
    @Mapping(target = "listCompraProducto", ignore = true)
    Compra toCompra(Purchase purchase);
}
