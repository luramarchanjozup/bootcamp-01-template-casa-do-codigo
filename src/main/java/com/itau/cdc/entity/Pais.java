package com.itau.cdc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name="nome", nullable = false)
	private String nome;

	public Pais(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public Pais() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public Pais ValidaPais(EntityManager manager, @NotNull Long idPais) {
		Pais pais = manager.find(Pais.class, idPais);
		if (pais == null) {
			throw new IllegalArgumentException("País não cadastrado.");
		}
		
		return pais;
	}
	
}
