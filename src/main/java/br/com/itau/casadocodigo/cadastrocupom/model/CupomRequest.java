package br.com.itau.casadocodigo.cadastrocupom.model;

import br.com.itau.casadocodigo.validador.AtributoUnico;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomRequest {

    @NotBlank
    @AtributoUnico(nomeDoAtributo = "codigo", classeDeDominio = Cupom.class)
    private String codigo;
    @NotNull
    @Positive
    private BigDecimal percentual;
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public Cupom toModel() {
        return new Cupom(this.codigo, this.percentual, this.validade);
    }
}
