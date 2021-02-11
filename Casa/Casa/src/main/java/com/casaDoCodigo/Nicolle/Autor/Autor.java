package com.casaDoCodigo.Nicolle.Autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private @NotBlank String nome;
	private @NotBlank @Email String email;
	private @NotBlank String descricao;
	
	@PastOrPresent
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Deprecated
	public Autor() {
	}

	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		
		
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", createdAt=" + createdAt
				+ "]";
	}

	public String getNome() {
		return nome;
	}

	



}
