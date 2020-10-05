package com.guiferrini.CasaCodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
	
	@Id
	@Column(name="id",nullable=false)
	@SequenceGenerator(name="autor_seq",sequenceName = "autor_seq_id",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="autor_seq")
	private Long id;
	
	private String nome;
	private String email;
	private String descricao;
	
	/*
	 * teste: comentario p @Deprecated
	 * */
	@Deprecated
	public Autor() {
	}

	public Autor(Long id, String nome, String email, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

