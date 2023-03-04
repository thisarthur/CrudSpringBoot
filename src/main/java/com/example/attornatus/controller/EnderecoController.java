package com.example.attornatus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attornatus.model.Endereco;
import com.example.attornatus.service.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

	private final EnderecoService enderecoService;

	@Autowired
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	//Endpoint Buscar Endereco por Id
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findByIdEndereco(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoService.findByIdEndereco(id);
		return endereco.isPresent() ? ResponseEntity.ok(endereco.get()) : ResponseEntity.notFound().build();
	}

	//Buscar todos endereços
	@GetMapping
	public ResponseEntity<List<Endereco>> findAllEnderecos() {
		return ResponseEntity.ok(enderecoService.findAllEnderecos());
	}

	//Salvar endereço
	@PostMapping
	public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) {
		return new ResponseEntity<>(enderecoService.saveEndereco(endereco), HttpStatus.CREATED);
	}

	//Editar endereço
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> editEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
		endereco.setId(id);
		return new ResponseEntity<>(enderecoService.saveEndereco(endereco), HttpStatus.OK);
	}

	//Deletar endereço
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
		enderecoService.deleteEndereco(id);
		return ResponseEntity.noContent().build();
	}
}
