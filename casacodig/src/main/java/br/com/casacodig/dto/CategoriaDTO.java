package br.com.casacodig.dto;

import javax.validation.constraints.NotBlank;

import br.com.casacodig.model.Categoria;
import br.com.casacodig.validator.ValorUnico;

//Contagem de Pontos - TOTAL:1
//1 - Categoria

public class CategoriaDTO {

	@NotBlank @ValorUnico(classe = Categoria.class, campo = "nome")
	private String nome;
	
	@Deprecated
	public CategoriaDTO() {
	}
	
	public CategoriaDTO(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
	public String getNome() {
		return this.nome;
	}
}
