package br.com.zup.treinocasadocodigo.entities.cupom;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Contagem de carga intrínseca da classe: 0
 */

public class CupomAtualizadoRequest {

    @NotEmpty
    private String codigo;

    @NotNull
    @Positive
    private BigDecimal desconto;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

}
