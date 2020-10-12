package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.ItemPedido;
import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.validations.ExistId;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovoItemPedidoRequest {

    @ExistId(className = Livro.class, fieldName = "id") //1
    private @NotNull Long idLivro;
    @Min(1)
    private @NotNull @Positive int quantidade;

    @Deprecated
    public NovoItemPedidoRequest(){}

    public NovoItemPedidoRequest(@NotNull Long idLivro,
                                 @NotNull @Min(1) @Positive int quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public ItemPedido toModel(EntityManager entityManager){ //2
        Livro livro = entityManager.find(Livro.class, this.idLivro); //3
        return new ItemPedido(livro, this.quantidade);
    }

}
