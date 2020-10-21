package br.com.zup.casadocodigo.novacompra;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.casadocodigo.livro.Livro;
import br.com.zup.casadocodigo.validacao.IdExiste;

public class ItemCarrinhoDTO {

	@NotNull
	@IdExiste(domainClass = Livro.class, fieldName = "idLivro")
	private Integer idLivro;

	@Positive
	private int quantidade;

	public ItemCarrinhoDTO(@NotNull Integer idLivro, @Positive int quantidade) {
		this.idLivro = idLivro;
		this.quantidade = quantidade;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

}
