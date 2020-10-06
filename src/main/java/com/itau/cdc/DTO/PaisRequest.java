package com.itau.cdc.DTO;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.Pais;


public class PaisRequest {

	@NotBlank
	@JsonProperty("nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
	
}
