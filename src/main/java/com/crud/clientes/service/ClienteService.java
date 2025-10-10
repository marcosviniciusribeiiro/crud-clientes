package com.crud.clientes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.clientes.dto.ClienteDTO;
import com.crud.clientes.mapper.ClienteMapper;
import com.crud.clientes.model.Cliente;
import com.crud.clientes.repository.ClienteRepository;

@Service
public class ClienteService {
	public ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public void salvarCliente(ClienteDTO dto) {
		clienteRepository.save(ClienteMapper.toEntity(dto));
	}
	
	public List<ClienteDTO> listarClientes(){
		return clienteRepository.findAll()
						 .stream()
						 .map(ClienteMapper::toDTO)
						 .toList();
	}
	public ClienteDTO buscarPorId(Long id) {
		Cliente c = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID não encontrado: " + id));
		return ClienteMapper.toDTO(c);
	}
	public void excluirCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}