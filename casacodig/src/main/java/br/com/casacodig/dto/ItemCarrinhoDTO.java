package br.com.casacodig.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.casacodig.model.ItemCarrinho;
import br.com.casacodig.model.Livro;
import br.com.casacodig.validator.IdExistente;

public class ItemCarrinhoDTO {

	@IdExistente(classe = "Livro", campo = "id")
	private Long idLivro;
	@Positive @NotNull
	private int quantidade;
	
	
	public ItemCarrinhoDTO(@NotNull Long idLivro, @Positive @NotNull int quantidade) {
		super();
		this.idLivro = idLivro;
		this.quantidade = quantidade;
	}

	public ItemCarrinho toModel(EntityManager manager) {
		@NotNull Livro livro = manager.find(Livro.class, this.idLivro);
		return new ItemCarrinho(livro, this.quantidade);
	}

	public Long getIdLivro() {
		return idLivro;
	}


	public int getQuantidade() {
		return quantidade;
	}
	
	@Override
	public String toString() {
		return "ItemCarrinhoDTO [idLivro=" + idLivro + ", quantidade=" + quantidade + "]";
	}
	
	
	
}
