package br.com.itau.casadocodigo.casadocodigoAPI.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.UniqueValue;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Autor;

public class AutorForm {

	@NotBlank
	private String nome;
	@Email(message = "O email inserido deve ser válido!")
	@NotBlank
	// 1
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	@NotBlank
	@Size(min = 0, max = 400)
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

	public Autor converter() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
