package br.com.casacodig.dto;

import javax.validation.constraints.NotBlank;
import br.com.casacodig.model.Categoria;

//Contagem de Pontos - TOTAL:0

public class CategoriaDTO {

	@NotBlank
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
		return nome;
	}

	
}
