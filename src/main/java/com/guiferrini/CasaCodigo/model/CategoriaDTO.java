package com.guiferrini.CasaCodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

	@NotBlank(message = "Nome obrigatório")
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
