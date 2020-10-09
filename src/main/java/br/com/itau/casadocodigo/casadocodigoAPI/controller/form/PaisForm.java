package br.com.itau.casadocodigo.casadocodigoAPI.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.UniqueValue;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Pais;

public class PaisForm {

	@NotBlank
	// 1
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public Pais converter() {

		return new Pais(this.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
