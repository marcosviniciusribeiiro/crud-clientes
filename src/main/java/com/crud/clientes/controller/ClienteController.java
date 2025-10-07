package com.crud.clientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.clientes.dto.ClienteDTO;
import com.crud.clientes.service.ClienteService;

import jakarta.validation.Valid;

@Controller
public class ClienteController {
	public ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastrar")
	public String formulario(Model model) {
		model.addAttribute("clienteDTO", new ClienteDTO());
		return "index";
	}
	
	@PostMapping("/cadastrar")
	public String salvarCliente(@ModelAttribute("clienteDTO") @Valid ClienteDTO clienteDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "index";
		}
		service.salvarCliente(clienteDTO);
		return "redirect:/cadastrar";
	}
}