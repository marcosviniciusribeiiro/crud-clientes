package com.crud.clientes.dto;

import com.crud.clientes.model.Cliente;

import jakarta.validation.constraints.NotBlank;

public class EnderecoDTO {
	private Long id;

	@NotBlank(message = "O CEP é obrigatório")
	private String cep; 

	@NotBlank(message = "O estado é obrigatório")
	private String estado;

	@NotBlank(message = "A cidade é obrigatória")
	private String cidade;
	
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
