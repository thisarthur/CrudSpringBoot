package com.example.attornatus.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.attornatus.model.Endereco;
import com.example.attornatus.model.Pessoa;
import com.example.attornatus.repository.EnderecoRepository;
import com.example.attornatus.repository.PessoaRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void run(String... args) throws Exception{
		
		//classe para injetar dados no BD para testes!
		
		Pessoa p1 = new Pessoa(null, "Maria", "11/05/2001", null);
		Pessoa p2 = new Pessoa(null, "Joao", "25/04/1998", null);
		Pessoa p3 = new Pessoa(null, "Jose", "21/01/1958", null);
			
		
		Endereco e1 = new Endereco(null, "Rua 2", "04652005", "2", "SP", p1, true);
		Endereco e2 = new Endereco(null, "Rua abc", "23412005", "3242", "SP", p2, true);
		Endereco e3 = new Endereco(null, "Rua def", "23412005", "1533", "SP", p2, true);
		Endereco e4 = new Endereco(null, "Rua fgh", "23412005", "322", "SP", p1, true);
		Endereco e5 = new Endereco(null, "Rua eersd", "23412005", "856", "SP", p3, true);
		
	
				
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
		
	
		
		
		
	}
}
