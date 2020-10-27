package com.casaDoCodigo.Nicolle.Categoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.casaDoCodigo.Nicolle.Validadores.MinhaAnotacao;

public class NovaCategoriaForm {
	
	@NotBlank
	@MinhaAnotacao(dominioClasse = Categoria.class, nomeCampo = "categoria")
	@Column(unique=true)
	private String categoria;

	

	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Categoria novaCategoria() {
		
		return new Categoria(categoria);
	}
	
	
}
