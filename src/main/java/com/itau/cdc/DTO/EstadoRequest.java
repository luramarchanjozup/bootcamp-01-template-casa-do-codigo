package com.itau.cdc.DTO;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.Estado;
import com.itau.cdc.entity.Pais;

public class EstadoRequest {

	@NotBlank
	@JsonProperty("nome")
	private String nome;
	
	@NotNull
	@JsonProperty("id_pais")
	private Long idPais;

	public String getNome() {
		return nome;
	}

	public @Valid Estado toModel(EntityManager manager) {
		
		Pais pais = manager.find(Pais.class, idPais);
		
		if(pais == null){
			throw new IllegalArgumentException("País não cadastrado.");
		}
		
		return new Estado(nome, pais);
	}

	public Long getIdPais() {
		return idPais;
	}
	
}
