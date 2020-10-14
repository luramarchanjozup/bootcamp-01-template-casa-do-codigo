package br.com.ecommerce.cdc.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 1
 *
 */


@Embeddable
public class ItensPedido {

    @NotNull
    @ManyToOne
    // +1
    private Livro livro;
    @NotNull
    @Positive
    private Integer quantidade;

    public ItensPedido() {
    }

    public ItensPedido(@NotNull Livro livro, @NotNull @Positive Integer quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal(){
        return livro.getPreco().multiply(new BigDecimal(quantidade));
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "livroId=" + livro +
                ", quantidade=" + quantidade +
                '}';
    }


}
