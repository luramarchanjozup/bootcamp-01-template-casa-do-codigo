package com.cdcAPI.api.model.Request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CompraItemRequest {

    @NotNull
    private Long livroId;
    @NotNull
    @Min(1)
    private Integer quantidade;

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
}
