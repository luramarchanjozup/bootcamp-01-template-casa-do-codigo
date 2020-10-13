package br.com.thyagoribeiro.casadocodigo.rest.contract;

import br.com.thyagoribeiro.casadocodigo.domain.Cupom;
import br.com.thyagoribeiro.casadocodigo.validator.Exist;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

// CDD - Total 1

public class NovoCupomRequest {

    @NotNull
    @Exist(domainClass = Cupom.class, fieldName = "codigo", expected = false) // CDD 1 - Classe Cupom
    private String codigo;

    @NotNull
    @Positive
    private int percentual;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private Date validade;

    @Deprecated
    public NovoCupomRequest() {
    }

    public NovoCupomRequest(@NotNull String codigo, @NotNull @Positive int percentual, @Future Date validade) {
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

    public int getPercentual() {
        return percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Cupom toModel() {
        return new Cupom(codigo, percentual, validade);
    }
}
