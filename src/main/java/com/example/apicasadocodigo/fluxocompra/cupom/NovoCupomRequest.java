package com.example.apicasadocodigo.fluxocompra.cupom;

import com.example.apicasadocodigo.compartilhado.UniqueValue;
import com.example.apicasadocodigo.fluxocompra.cupom.Cupom;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoCupomRequest {
    @NotBlank
    @UniqueValue(domainClass = Cupom.class, fieldName = "codigo", message = "Um cupom com este código já existe")
    private String codigo;
    @Positive
    @NotNull
    private BigDecimal desconto;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    public Cupom toModel() {
        return new Cupom(this.codigo, this.desconto, this.validade);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
