package com.crud.clientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.crud.clientes.dto.ClienteDTO;
import com.crud.clientes.service.ClienteService;

import jakarta.validation.Valid;

@Controller
public class ClienteController {
	public ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	@GetMapping("/clientes")
	public String listarClientes(Model model) {
		model.addAttribute("clientes", service.listarTodos());
		return "clientes";
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
		
	@PutMapping("/clientes/atualizar/{id}")
	public String atualizarCliente(@PathVariable Long id, @ModelAttribute ClienteDTO cliente) {
		cliente.setId(id);
		service.salvarCliente(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/clientes/editar/{id}")
	public String editarCliente(@PathVariable Long id, Model model) {
		ClienteDTO dto = service.buscarPorId(id);
		model.addAttribute("clienteDTO", dto);
		return "index";
	}
	
	@DeleteMapping("/clientes/excluir/{id}")
	public String excluirCliente(@PathVariable Long id) {
		service.excluirCliente(id);
		return "redirect:/clientes";
	}
}