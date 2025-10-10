package com.crud.clientes.mapper;

import com.crud.clientes.dto.EnderecoDTO;
import com.crud.clientes.model.Endereco;

public class EnderecoMapper {
	public static Endereco toEntity(EnderecoDTO dto) {
		Endereco e = new Endereco();
		e.setId(dto.getId());
		e.setCep(dto.getCep());
		e.setEstado(dto.getEstado());
		e.setCidade(dto.getCidade());
		return e;
	}
	
	public static EnderecoDTO toDTO(Endereco e) {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setId(e.getId());
		dto.setCep(e.getCep());
		dto.setEstado(e.getEstado());
		dto.setCidade(e.getCidade());
		return dto;
	}
}
