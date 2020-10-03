package com.itau.cdc.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name="nome", nullable = false)
	private String nome;
	
	@NotBlank
	@Email
	@Column(name="email", nullable = false)
	private String email;
	
	@NotBlank
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@CreatedDate
	@Column(name="intante_criacao")
	private LocalDateTime instanteCriacao = LocalDateTime.now();

	public Autor() {
		
	}
	
	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor(@NotNull Long idAutor) {
		super();
		this.id=idAutor;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", instanteCriacao=" + instanteCriacao + "]";
	}

	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}
	
}
