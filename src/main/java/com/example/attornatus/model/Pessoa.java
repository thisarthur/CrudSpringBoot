package com.example.attornatus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String dataNascimento;

	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> endereco = new ArrayList<>();

	private Integer enderecoPrincipal;

	// construtores, getters e setters

	public Pessoa() {

	}

	public Pessoa(Long id, String nome, String dataNascimento, List<Endereco> endereco) {
		super();
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}
	
	
	public void setEnderecoPrincipal(Integer indice) {
		if (indice < 0 || indice >= endereco.size()) {
			throw new IllegalArgumentException("Índice inválido");
		}
		this.enderecoPrincipal = indice;
		for (int i = 0; i < endereco.size(); i++) {
			endereco.get(i).setPrincipal(i == indice);
		}
	}
}
