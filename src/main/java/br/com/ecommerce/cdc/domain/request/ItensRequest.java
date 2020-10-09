package br.com.ecommerce.cdc.domain.request;

import br.com.ecommerce.cdc.anotacao.ExistInDataBase;
import br.com.ecommerce.cdc.domain.model.ItensPedido;
import br.com.ecommerce.cdc.domain.model.Livro;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 2
 *
 */

public class ItensRequest {

    @NotNull
    @ExistInDataBase(nameClass = "Livro", nameFieldClass = Livro.class)
    private Long livroId;
    @NotNull
    @Positive
    private Integer quantidade;

    public ItensRequest() {
    }

    public ItensRequest(Long livroId, Integer quantidade) {
        this.livroId = livroId;
        this.quantidade = quantidade;
    }

    // +1
    public ItensPedido toModel(EntityManager manager){
        // +1
        Livro livro = manager.find(Livro.class, livroId);

        return new ItensPedido(livro, quantidade);
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItensRequest{" +
                "livroId=" + livroId +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItensRequest that = (ItensRequest) o;
        return livroId.equals(that.livroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livroId);
    }
}
