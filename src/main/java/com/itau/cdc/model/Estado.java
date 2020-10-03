package com.itau.cdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name="nome", nullable = false)
	private String nome;
	
	@NotNull
	@Column(name="id_pais", nullable = false)
	private Pais pais;

	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		super();
		this.nome=nome;
		this.pais=pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getIdPais() {
		return pais;
	}
	
}
