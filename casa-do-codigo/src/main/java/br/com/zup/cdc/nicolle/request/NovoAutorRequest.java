package br.com.zup.cdc.nicolle.request;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.cdc.nicolle.model.Autor;
import br.com.zup.cdc.nicolle.validadores.SemValorRepetido;

public class NovoAutorRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@SemValorRepetido(dominioClasse = Autor.class, nomeCampo = "email")
	private String email;
	
	@NotBlank
	@Size(max = 400)
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
