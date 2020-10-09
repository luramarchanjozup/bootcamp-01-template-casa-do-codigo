package com.example.apicasadocodigo.fluxocompra.itemcarrinho;

import com.example.apicasadocodigo.compartilhado.ExistsId;
import com.example.apicasadocodigo.fluxocompra.itemcarrinho.ItemCarrinho;
import com.example.apicasadocodigo.livro.Livro;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovoItemCarrinhoRequest {
    @NotNull
    @ExistsId(domainClass = Livro.class, fieldName = "id")
    private Long idLivro;
    @Positive
    private int quantidade;

    public ItemCarrinho toModel(EntityManager manager) {
        @NotNull Livro livro = manager.find(Livro.class, idLivro);
        return new ItemCarrinho(livro, quantidade);
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
