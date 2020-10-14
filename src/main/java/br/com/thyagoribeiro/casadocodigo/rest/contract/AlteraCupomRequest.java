package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Cupom;
import br.com.thyagoribeiro.casadocodigo.validator.Exist;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Date;

// CDD - Total 1

public class AlteraCupomRequest {

    @NotNull
    private String codigo;

    @NotNull
    @Positive
    private Long percentual;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    @Deprecated
    public AlteraCupomRequest() {
    }

    public AlteraCupomRequest(@NotNull String codigo, @NotNull @Positive Long percentual, @Future LocalDate validade) {
        this.codigo = codigo;
        this.percentual = percentual;
        this.validade = validade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getPercentual() {
        return percentual;
    }

    public void setPercentual(Long percentual) {
        this.percentual = percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Cupom toModel(Cupom cupom) {
        cupom.setCodigo(codigo);
        cupom.setPercentual(percentual);
        cupom.setValidade(validade);
        return cupom;
    }

}
