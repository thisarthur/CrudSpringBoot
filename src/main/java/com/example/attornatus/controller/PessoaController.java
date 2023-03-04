package com.example.attornatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.attornatus.model.Pessoa;
import com.example.attornatus.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	//Listar todas as Pessoas
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = pessoaService.findAll();
		return ResponseEntity.ok().body(list);
	}

	//Buscar pessoa por ID
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Pessoa obj = pessoaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	//Criar Pessoa
	@PostMapping
	public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.createPessoa(pessoa), HttpStatus.CREATED);
	}

	//Editar pessoa
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> editPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		pessoa.setId(id);
		return new ResponseEntity<>(pessoaService.editPessoa(pessoa), HttpStatus.OK);
	}

	//deletar pessoa
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
		pessoaService.deletePessoa(id);
		return ResponseEntity.noContent().build();
	}
	
	//Setar endereço principal
	 @PatchMapping("/{id}/endereco-principal")
	    public ResponseEntity<Void> setEnderecoPrincipal(@PathVariable Long id, @RequestParam Integer indice) {
	        pessoaService.setEnderecoPrincipal(id, indice);
	        return ResponseEntity.noContent().build();
	    }
	}

