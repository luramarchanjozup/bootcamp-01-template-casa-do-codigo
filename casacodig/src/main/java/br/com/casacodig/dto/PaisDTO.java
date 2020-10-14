package br.com.casacodig.dto;

import javax.validation.constraints.NotBlank;
import br.com.casacodig.model.Pais;
import br.com.casacodig.validator.ValorUnico;

//Contagem de Pontos - TOTAL:1
//1 - Pais

public class PaisDTO {

	@NotBlank @ValorUnico(classe = Pais.class, campo = "nome")
	private String nome;
	
	@Deprecated
	public PaisDTO() {
	}

	public PaisDTO(@NotBlank String nome) {
		super();
		this.nome = nome;
	}


	public Pais toModel() {
		return new Pais(this.nome);
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "PaisDTO [nome=" + nome + "]";
	}
	
}
