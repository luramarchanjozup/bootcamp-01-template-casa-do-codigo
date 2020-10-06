package com.itau.cdc.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.Autor;

public class DetalheSiteAutorResponse {

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("descricao")
	private String descricao;
		
	public DetalheSiteAutorResponse(Autor autor) {
		super();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
