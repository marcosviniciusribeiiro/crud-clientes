package com.crud.clientes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.clientes.dto.EnderecoDTO;
import com.crud.clientes.mapper.EnderecoMapper;
import com.crud.clientes.model.Endereco;
import com.crud.clientes.repository.EnderecoRepository;

@Service
public class EnderecoService {
	public EnderecoRepository enderecoRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public void salvarEndereco(EnderecoDTO dto) {
		enderecoRepository.save(EnderecoMapper.toEntity(dto));
	}
	
	public List<EnderecoDTO> listarEnderecos(){
		return enderecoRepository.findAll()
								 .stream()
								 .map(EnderecoMapper::toDTO)
								 .toList();
	}
	
	public EnderecoDTO buscarPorId(Long id) {
		Endereco e = enderecoRepository.findById(id)
									   .orElseThrow(() -> new IllegalArgumentException("Id não encontrado: " + id));
		return EnderecoMapper.toDTO(e);
	}
	
	public void excluirEndereco(Long id) {
		enderecoRepository.deleteById(id);
	}
}