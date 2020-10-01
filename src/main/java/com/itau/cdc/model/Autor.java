package com.itau.cdc.model;

import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.itau.cdc.entity.AutorEntity;

public class Autor {

	@Id
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String descricao;
	
	private LocalDateTime instanteCriacao = LocalDateTime.now();

	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
	
	public AutorEntity toEntity(AutorEntity autorEntity) {
		autorEntity.setNome(nome);
		autorEntity.setEmail(email);
		autorEntity.setDescricao(descricao);
		autorEntity.setInstanteCriacao(instanteCriacao);
		
		return autorEntity;
	}
	
}
