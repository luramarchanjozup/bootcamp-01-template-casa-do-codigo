package com.casadocodigo.casadocodigo.Estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.Pais.Pais;
import com.sun.istack.NotNull;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	@ManyToOne
	private @NotNull @Valid Pais pais;

	public String getNome() {
		return nome;
	}

	@Deprecated
	public Estado() {

	}

	public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
		this.nome = nome;
		this.pais = pais;

	}

	public String toString() {
		return "Estado [id = " + id + ", nome = " + nome + ", pais = " + pais + "]";

	}

	public boolean pertencePais(Pais pais) {
		return this.pais.equals(pais);
	}

	public Pais getPais() {
		return pais;
	}

}
