package com.itau.cdc.model.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.model.Autor;

public class NovoAutorRequest {

	@NotBlank
	@JsonProperty("nome")
	private String nome;
	
	@NotBlank
	@Email
	@JsonProperty("email")
	private String email;
	
	@Size(max = 400)
	@NotBlank
	@JsonProperty("descricao")
	private String descricao;
	
	public NovoAutorRequest (@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;		
	}
	
	public Autor toModel() {
		return new Autor(nome, email, descricao);
	}

	public String getEmail() {
		return email;
	}
	
}
