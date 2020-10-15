package br.com.carlos.casadocodigo.api.dto.request;

import br.com.carlos.casadocodigo.api.handler.ExistsById;
import br.com.carlos.casadocodigo.domain.entity.ItemPedido;
import br.com.carlos.casadocodigo.domain.entity.Livro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter @Setter
public class RequestItensDto {
    @NotNull @ExistsById(domainClass = Livro.class, fieldName = "id")
    private Long idLivro;
    @Positive
    private int quantidade;

    public ItemPedido toEntity(EntityManager manager) {
        Livro livro = manager.find(Livro.class, getIdLivro());
        return new ItemPedido(livro, getQuantidade());
    }

    public RequestItensDto() {
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
