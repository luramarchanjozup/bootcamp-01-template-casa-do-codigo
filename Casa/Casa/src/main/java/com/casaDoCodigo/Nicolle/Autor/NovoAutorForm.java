package com.casaDoCodigo.Nicolle.Autor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.casaDoCodigo.Nicolle.Validadores.MinhaAnotacao;


public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@MinhaAnotacao(dominioClasse = Autor.class, nomeCampo = "email")
	private String email;
	
	@NotBlank
	@Column(unique=true)
	private String descricao;

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

	public Autor novoAutor() {
		return new Autor(nome,email,descricao);
	}
	
	
}
