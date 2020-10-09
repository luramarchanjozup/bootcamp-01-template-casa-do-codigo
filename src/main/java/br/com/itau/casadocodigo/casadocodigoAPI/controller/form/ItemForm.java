package br.com.itau.casadocodigo.casadocodigoAPI.controller.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.QuantidadeLivros;
import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.VerificaExistenciaTuplaRelacao;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Livro;

public class ItemForm {

	// 1
	@VerificaExistenciaTuplaRelacao(domainClass = Livro.class, fieldName = "id")
	private int idLivro;
	@Min(value = 1)
	private int quantidade;

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
