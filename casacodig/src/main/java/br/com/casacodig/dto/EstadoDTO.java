package br.com.casacodig.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.casacodig.model.Estado;
import br.com.casacodig.model.Pais;
import br.com.casacodig.validator.IdExistente;
import br.com.casacodig.validator.ValorUnico;

//Contagem de Pontos - TOTAL:2
//1 - Pais
//1 - Estado

public class EstadoDTO {

	@NotBlank @ValorUnico(classe = Estado.class, campo = "nome")
	private String nome;
	@NotNull @IdExistente(classe = "Pais", campo = "id")
	private Long idPais;
	
	
	public EstadoDTO(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}
	
	public Estado toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, this.idPais);
		return new Estado (this.nome, pais);
	}
	
}
