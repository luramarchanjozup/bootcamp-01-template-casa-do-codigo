package com.itau.cdc.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.Autor;

public class AutorResponse {

	@JsonProperty("id")
	private Long id;
	
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
	
	public AutorResponse(Long id, @NotBlank @Email String email, @NotBlank String nome, @NotBlank String descricao) {
		super();
		this.id=id;
		this.email=email;
		this.nome=nome;
		this.descricao=descricao;
	}

	public Autor toModel() {
		return new Autor(nome, email, descricao);
	}

	public String getEmail() {
		return email;
	}
	
}
