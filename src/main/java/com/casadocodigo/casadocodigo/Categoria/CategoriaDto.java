package com.casadocodigo.casadocodigo.Categoria;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.Validation.ValorUnico;

public class CategoriaDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @ValorUnico(campo = "nome", classe = Categoria.class) String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}

}