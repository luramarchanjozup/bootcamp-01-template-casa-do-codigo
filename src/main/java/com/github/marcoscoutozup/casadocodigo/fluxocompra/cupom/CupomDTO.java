package com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.marcoscoutozup.casadocodigo.validator.unique.Unique;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class CupomDTO {

    @NotBlank
    @Unique(campo = "codigo", classe = Cupom.class)
    private String codigo;

    @NotNull
    @Positive
    private Integer percentual;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate validade;

    //1
    public Cupom toModel(){
        return new Cupom(codigo, percentual, validade);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getPercentual() {
        return percentual;
    }

    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
