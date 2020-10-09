package com.example.apicasadocodigo.compra;

import com.example.apicasadocodigo.cupom.Cupom;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CupomAplicado {
    @ManyToOne
    private Cupom cupom;
    @Positive
    @NotNull
    private BigDecimal desconto;
    @Future
    @NotNull
    private LocalDate validade;

    @Deprecated
    public CupomAplicado() {
    }

    public CupomAplicado(Cupom cupom) {
        this.cupom = cupom;
        this.desconto = cupom.getDesconto();
        this.validade = cupom.getValidade();
    }

    public BigDecimal getDesconto() {
        return desconto;
    }
}
