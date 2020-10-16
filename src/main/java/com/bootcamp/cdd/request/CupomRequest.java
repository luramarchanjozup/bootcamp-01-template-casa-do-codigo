package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Cupom;
import com.bootcamp.cdd.shared.UniqueValue;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomRequest {
    @NotBlank(message = "O codigo precisa ser preenchido")
    @UniqueValue(fieldName = "codigo", domainClass = Cupom.class)
    private String codigo;
    @NotNull(message = "A porcentagem precisa ser preenchida") @Positive(message = "O valor precisa ser positivo")
    private double porcentagem;
    @Future(message = "a data precisa ser no futuro")
    private LocalDate dataValidade;

    public CupomRequest(@NotBlank(message = "O codigo precisa ser preenchido") String codigo, @NotNull(message = "A porcentagem precisa ser preenchida") @Positive(message = "O valor precisa ser positivo") double porcentagem, @Future(message = "a data precisa ser no futuro") LocalDate dataValidade) {
        this.codigo = codigo;
        this.porcentagem = porcentagem;
        this.dataValidade = dataValidade;
    }

    public Cupom toModel () {
        return new Cupom(this.codigo, this.porcentagem, this.dataValidade);
    }
}
