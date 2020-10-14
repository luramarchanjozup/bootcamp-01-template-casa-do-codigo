package com.guiferrini.CasaCodigo.model;

import javax.validation.constraints.NotBlank;

public class PaisDTO {
	
	@NotBlank(message="Nome é obrigatório")
	@ValorUnico(domainClass=Pais.class, fieldName="nome",message="Nome já existe, favor verificar.")
	private String nome;
	
	public PaisDTO() {
	}

	public PaisDTO(@NotBlank(message = "Nome é obrigatório") String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Pais toModel() {
		return new Pais(nome);
	}
}
