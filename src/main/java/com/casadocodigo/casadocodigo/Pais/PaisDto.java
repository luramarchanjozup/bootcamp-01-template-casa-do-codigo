package com.casadocodigo.casadocodigo.Pais;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.Validation.ValorUnico;

public class PaisDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @ValorUnico(campo = "nome", classe = Pais.class) String nome;

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}

}
