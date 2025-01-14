package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.Client;
import com.market.minimarket.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source="idCliente", target="idClient"),
            @Mapping(source="codigo", target="code"),
            @Mapping(source="nombre", target="name"),
            @Mapping(source="apellidos", target="lastName"),
            @Mapping(source="genero", target="gender"),
            @Mapping(source="fechaNacimiento", target="birthdate"),
            @Mapping(source="telefono", target="phone"),
            @Mapping(source="correo", target="email"),
            @Mapping(source="listCompras", target="listPurchase")
    })
    Client toclient(Cliente cliente);

    @InheritInverseConfiguration
    Cliente toCliente(Client client);
}
