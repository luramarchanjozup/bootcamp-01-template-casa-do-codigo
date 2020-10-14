package com.guiferrini.CasaCodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="pais")
public class Pais {

	@Id
	@Column(name="id", nullable=false)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;
	@GeneratedValue(generator = "UUID", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@NotNull(message="Nome é obrigatório")
	private String nome;
	
	@Deprecated
	public Pais() {
	}

	public Pais(@NotNull(message = "Nome é obrigatório") String nome) {
		super();
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
