package io.github.evertoncnsouza.domain.embedded;

import io.github.evertoncnsouza.domain.entity.Cupom;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

//Não tem PCI.
@Embeddable //Declara que está classe será integrada as outras entidades;
public class CupomAplicado {

    @ManyToOne //Um cupom aplicado tem um cupom, enquanto um cupom pode ser cupom aplicado várias vezes;
    private Cupom cupom;

    @Positive
    @NotNull
    private BigDecimal percentualDescontoMomento;

    @NotNull
    @Future
    private LocalDate validadeMomento;

    @Deprecated
    public CupomAplicado() {
    }

    public CupomAplicado(@Valid Cupom cupom) {
        this.cupom = cupom;
        this.percentualDescontoMomento = cupom.getPercentualDesconto();
        this.validadeMomento = cupom.getValidade();
    }

    public BigDecimal getPercentualDescontoMomento() {
        return percentualDescontoMomento;
    }

    @Override
    public String toString() {
        return "{" +
                "cupom=" + cupom +
                ", percentualDescontoMomento=" + percentualDescontoMomento +
                ", validadeMomento=" + validadeMomento +
                '}';
    }

}

