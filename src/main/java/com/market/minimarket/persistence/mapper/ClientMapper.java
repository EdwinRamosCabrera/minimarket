package com.market.minimarket.persistence.mapper;

import com.market.minimarket.domain.entity.Client;
import com.market.minimarket.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source="idCliente", target="idClient"),
            @Mapping(source="codigo", target="code"),
            @Mapping(source="nombres", target="name"),
            @Mapping(source="apellidos", target="lastName"),
            @Mapping(source="genero", target="gender"),
            @Mapping(source="fechaNacimiento", target="birthdate"),
            @Mapping(source="telefono", target="phone"),
            @Mapping(source="correo", target="email"),
    })
    Client toclient(Cliente cliente);

    List<Client> toListClients(List<Cliente> ListClientes);

    @InheritInverseConfiguration
    @Mapping(target = "listCompras", ignore = true)
    Cliente toCliente(Client client);
}
