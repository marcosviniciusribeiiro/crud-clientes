package com.crud.clientes.mapper;

import com.crud.clientes.dto.ClienteDTO;
import com.crud.clientes.model.Cliente;

public class ClienteMapper {
	public static Cliente toEntity(ClienteDTO dto) {
		Cliente c = new Cliente();
		c.setId(dto.getId());
		c.setNome(dto.getNome());
		c.setUsername(dto.getUsername());
		return c;
	}
	
	public static ClienteDTO toDTO(Cliente c) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(c.getId());
		dto.setNome(c.getNome());
		dto.setUsername(c.getUsername());
		return dto;
	}
}
