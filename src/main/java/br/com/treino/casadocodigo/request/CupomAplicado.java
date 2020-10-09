package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.Cupom;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.Embedded;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomAplicado {

    @NotBlank
    private String codigo;
    @NotNull
    @Positive
    private BigDecimal percentualDesconto;
    @NotNull @Future
    private LocalDate validade;

    public CupomAplicado(Cupom cupom) {
        this.codigo = cupom.getCodigo();
        this.percentualDesconto = cupom.getPercentualDesconto();
        this.validade = cupom.getValidade();
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto.divide(new BigDecimal(100));
    }



}
