package com.itau.cdc.model;

import javax.validation.constraints.NotBlank;

import com.itau.cdc.entity.CategoriaEntity;

public class Categoria {

	@NotBlank
	private String nome;

	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public CategoriaEntity toEntity(CategoriaEntity categoriaEntity) {
		categoriaEntity.setNome(nome);
		
		return categoriaEntity;
	}
	
}
