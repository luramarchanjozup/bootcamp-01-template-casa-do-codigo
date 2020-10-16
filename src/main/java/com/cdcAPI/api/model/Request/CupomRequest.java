package com.cdcAPI.api.model.Request;

import com.cdcAPI.model.Cupom;
import com.cdcAPI.validator.EntradaUnica;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//Complexidade = 2
//EntradaUnica, Cupom

public class CupomRequest {

    @NotBlank
    @EntradaUnica(domainClass = Cupom.class, fieldName = "codigo")
    private String codigo;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private BigDecimal porcentagem;

    @NotNull
    @Future
    private LocalDate validade;

    public Cupom toModel() {
        return new Cupom(codigo, porcentagem, validade);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(BigDecimal porcentagem) {
        this.porcentagem = porcentagem;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
