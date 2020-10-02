package com.itau.cdc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AutorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@Column(name="intante_criacao")
	private LocalDateTime instanteCriacao = LocalDateTime.now();

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

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	public void setInstanteCriacao(LocalDateTime instanteCriacao) {
		this.instanteCriacao = instanteCriacao;
	}

	public Long getId() {
		return id;
	}

	
	
}
