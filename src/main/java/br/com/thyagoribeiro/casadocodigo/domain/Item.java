package br.com.thyagoribeiro.casadocodigo.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

// CDD - Total 0

@Embeddable
public class Item {

    @NotNull
    private Long livroId;

    @NotNull
    @Positive
    private Long quantidade;

    @Deprecated
    public Item() {
    }

    public Item(@NotNull Long livroId, @NotNull @Positive Long quantidade) {
        this.livroId = livroId;
        this.quantidade = quantidade;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
