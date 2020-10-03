package com.itau.cdc.DTO;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.model.Categoria;

public class CategoriaRequest {

	@NotBlank
	@JsonProperty("nome")
	private String nome;

	public CategoriaRequest() {
		super();
	}

	public CategoriaRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}

	public String getNome() {
		return nome;
	}
	
}
