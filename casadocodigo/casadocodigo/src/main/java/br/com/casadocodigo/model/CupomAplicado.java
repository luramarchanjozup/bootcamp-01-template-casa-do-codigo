package br.com.casadocodigo.model;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embedded
public class CupomAplicado {
    @ManyToOne
    private Cupom cupom;

    @Positive
    @NotNull
    private BigDecimal descontoAtual;

    @NotNull
    @Future
    private LocalDate validadeAtual;

    @Deprecated
    public CupomAplicado() {

    }

    public CupomAplicado(Cupom cupom) {
        this.cupom = cupom;
        this.descontoAtual = cupom.getPercentualDesconto();
        this.validadeAtual = cupom.getValidade();
    }

    @Override
    public String toString() {
        return "CupomAplicado [cupom=" + cupom + ", descontoAtual="
                + descontoAtual + ", validadeAtual="
                + validadeAtual + "]";
    }


}
