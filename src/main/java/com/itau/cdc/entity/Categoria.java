package com.itau.cdc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.itau.cdc.DTO.CategoriaResponse;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name="nome", nullable = false)
	private String nome;

	public Categoria() {
		
	}
	
	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public Categoria(@NotNull Long categoria) {
		super();
		this.id = categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public @NotNull CategoriaResponse toResponse() {
		return new CategoriaResponse(id, nome);
	}
	
}
