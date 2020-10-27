package com.casadocodigo.casadocodigo.Autor;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.casadocodigo.casadocodigo.Validation.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class AutorDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	private @NotBlank @Email  @ValorUnico(campo = "email", classe = Autor.class) String email;
	private @NotBlank @Size(max = 400) String descricao;
	private @NotNull @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING) LocalDateTime instanteCriacao = LocalDateTime
			.now();

	public AutorDto(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
