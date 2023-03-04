package com.example.attornatus.dto;

import java.time.LocalDate;

public class PessoaDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private EnderecoDTO endereco;

    public PessoaDTO() {}

    public PessoaDTO(Long id, String nome, LocalDate dataNascimento, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
