package com.itau.cdc.DTO;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.Categoria;

public class CategoriaResponse {

	@JsonProperty("id")
	private Long id;
	
	@NotBlank
	@JsonProperty("nome")
	private String nome;

	public CategoriaResponse() {
		super();
	}

	public CategoriaResponse(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public CategoriaResponse(Long id, @NotBlank String nome) {
		super();
		this.id=id;
		this.nome=nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}
	
}
