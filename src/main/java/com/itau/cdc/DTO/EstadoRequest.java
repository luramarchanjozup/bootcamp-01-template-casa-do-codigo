package com.itau.cdc.DTO;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.model.Estado;
import com.itau.cdc.model.Pais;

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
		
		Assert.state(pais!=null, "Pais não cadastrado.");
		
		return new Estado(nome, pais);
	}

	public Long getIdPais() {
		return idPais;
	}
	
}
