package com.casadocodigo.casadocodigo.Pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;

	@Deprecated
	public Pais() {
	}

	public Pais(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String toString() {
		return "Pais [id = " + id + ", nome = " + nome + "]";

	}

	public String getNome() {
		return nome;
	}
	
}
