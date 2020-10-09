package br.com.itau.casadocodigo.casadocodigoAPI.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.UniqueValue;
import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.VerificaExistenciaTuplaRelacao;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Estado;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Pais;

public class EstadoForm {

	@NotBlank
	// 1
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	@NotBlank
	// 1
	@VerificaExistenciaTuplaRelacao(domainClass = Pais.class, fieldName = "nome")
	private String pais;

	// 1
	public Estado converter(Pais pais) {
		return new Estado(this.nome, pais);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
