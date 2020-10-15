package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.annotation.ObjetoValido;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.ItemCompra;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Livro;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovoPedidoItemRequest {

    @NotNull
    @ObjetoValido(domainClass = Livro.class, fieldName = "id")
    private Integer idLivro;
    @Positive
    private Integer quantidade;

    public NovoPedidoItemRequest(@NotNull Integer idLivro, @Positive Integer quantidade){
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Integer getIdLivro(){
        return idLivro;
    }

    public ItemCompra toModel(EntityManager entityManager){
        @NotNull Livro livro = entityManager.find(Livro.class, idLivro);
        return new ItemCompra(livro, quantidade);
    }
}
