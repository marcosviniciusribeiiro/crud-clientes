package com.crud.clientes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.clientes.dto.ClienteDTO;
import com.crud.clientes.mapper.ClienteMapper;
import com.crud.clientes.model.Cliente;
import com.crud.clientes.repository.ClienteRepository;

@Service
public class ClienteService {
	public ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public void salvarCliente(ClienteDTO dto) {
		repository.save(ClienteMapper.toEntity(dto));
	}
	
	public List<ClienteDTO> listarTodos(){
		return repository.findAll()
						 .stream()
						 .map(ClienteMapper::toDTO)
						 .toList();
	}
	public ClienteDTO buscarPorId(Long id) {
		Cliente c = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID não encontrado: " + id));
		return ClienteMapper.toDTO(c);
	}
	public void excluirCliente(Long id) {
		repository.deleteById(id);
	}
}