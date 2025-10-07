package com.crud.clientes.dto;

import jakarta.validation.constraints.NotBlank;

public class EnderecoDTO {
	private Long id;

	@NotBlank(message = "O CEP é obrigatório")
	private int cep; 

	@NotBlank(message = "O estado é obrigatório")
	private String estado;

	@NotBlank(message = "A cidade é obrigatória")
	private String cidade;

	private String bairro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
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
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
