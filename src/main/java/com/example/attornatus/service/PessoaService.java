package com.example.attornatus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attornatus.model.Pessoa;
import com.example.attornatus.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private final PessoaRepository pessoaRepository;

	
	private Pessoa pessoa;
	
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

	
	
    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa findById(Long id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
    	return obj.get();
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa editPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
    
   	public void setEnderecoPrincipal(Long id, Integer indice) {
		pessoa.setEnderecoPrincipal(indice);
		
	}

}