package com.example.attornatus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attornatus.model.Endereco;
import com.example.attornatus.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findByIdEndereco(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco saveEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
    
    public Endereco editEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

}
