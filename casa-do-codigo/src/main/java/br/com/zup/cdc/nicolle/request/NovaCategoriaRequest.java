package br.com.zup.cdc.nicolle.request;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import br.com.zup.cdc.nicolle.model.Categoria;
import br.com.zup.cdc.nicolle.validadores.SemValorRepetido;

public class NovaCategoriaRequest {
	@NotBlank
	@SemValorRepetido(dominioClasse = Categoria.class, nomeCampo = "categoria")
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
