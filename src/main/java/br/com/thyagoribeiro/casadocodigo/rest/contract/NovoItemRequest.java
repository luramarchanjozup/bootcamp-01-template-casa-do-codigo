package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Item;
import br.com.thyagoribeiro.casadocodigo.domain.Livro;
import br.com.thyagoribeiro.casadocodigo.validator.Exist;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

// CDD - Total 1

public class NovoItemRequest {

    @NotNull
    @Exist(domainClass = Livro.class, fieldName = "id", expected = true)
    private Long livroId;

    @NotNull
    @Positive
    private int quantidade;

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Item toModel(){
        return new Item(livroId, quantidade);
    } // CDD 1 - Classe Item
}
