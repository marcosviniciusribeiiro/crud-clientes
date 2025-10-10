package com.crud.clientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.clientes.dto.EnderecoDTO;
import com.crud.clientes.service.EnderecoService;

import jakarta.validation.Valid;

@Controller
public class EnderecoController {
	public EnderecoService service;
	
	public EnderecoController(EnderecoService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastrar/endereco")
	public String formulario(Model model) {
		model.addAttribute("enderecoDTO", new EnderecoDTO());
		return "cadastro_endereco";
	}
	
	@PostMapping("/cadastrar/endereco")
	public String salvarEndereco(@ModelAttribute("enderecoDTO") @Valid EnderecoDTO enderecoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "cadastro_endereco";
		}
		service.salvarEndereco(enderecoDTO);
		return "redirect:/cadastrar/endereco";
	}
	
	@GetMapping("/enderecos")
	public String listarEnderecos(Model model) {
		model.addAttribute("enderecos", service.listarEnderecos());
		return "enderecos";
	}
	//Editar cadastro: ("/enderecos/editar/{id}")
	//Atualizar cadastro: ("/enderecos/atualizar/{id}")
	//Deletar cadastro: ("enderecos/excluir/{id}")
}
