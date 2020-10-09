package com.guiferrini.CasaCodigo.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {
	
	@NotBlank(message = "Nome obrigatório")
	private String nome;
	
	@NotBlank(message = "Email obrigatório")
	@Email (message = "Favor digitar um Email válido")
	private String email;
	
	@NotBlank(message = "Descrição obrigatório")
	@Size(max=400, message = "Máximo 400 caracteres")
	private String descricao;
	
	private LocalDateTime horaRegistro = LocalDateTime.now();

	public AutorDTO() {
	}

	public AutorDTO(
			@NotBlank String nome, 
			@NotBlank @Email String email, 
			@NotBlank @Size(max=400) String descricao
			) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
	
	public String buscaEmail() {
		return this.email;
	}
	
	public Autor toModel() {
		Autor obj = new Autor(nome, email, descricao);
		return obj; 
	}
}

