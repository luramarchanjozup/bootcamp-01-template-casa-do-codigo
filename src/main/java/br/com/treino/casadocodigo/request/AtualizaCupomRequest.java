package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.Cupom;
import br.com.treino.casadocodigo.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AtualizaCupomRequest {

    private @NotBlank String codigo;
    private @NotNull @Positive BigDecimal percentualDesconto;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private @NotNull @Future LocalDate validade;

    @Deprecated
    public AtualizaCupomRequest(){}

    public AtualizaCupomRequest(Cupom request) {
        this.codigo = request.getCodigo();
        this.percentualDesconto = request.getPercentualDesconto();
        this.validade = request.getValidade();
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
