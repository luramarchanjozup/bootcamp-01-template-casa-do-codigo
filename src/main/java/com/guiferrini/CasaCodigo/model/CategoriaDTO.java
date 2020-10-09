package com.guiferrini.CasaCodigo.model;

import javax.validation.constraints.NotBlank;

import com.guiferrini.CasaCodigo.model.ValorUnico;

public class CategoriaDTO {

	@NotBlank(message = "Nome obrigatório")
	@ValorUnico(domainClass = Categoria.class, fieldName = "nome", message = "Nome da Categoria já existente")
	private String nome;
	
	@Deprecated
	public CategoriaDTO() {
	}

	public CategoriaDTO(@NotBlank(message = "Nome obrigatório") String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria toModel() {
		Categoria obj = new Categoria(nome);
		return obj;
	}
}
