package br.com.treino.casadocodigo.request;

import br.com.treino.casadocodigo.model.Cupom;
import com.sun.istack.NotNull;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CupomAplicado {

    @ManyToOne
    private Cupom cupom;
    private @NotNull @Positive BigDecimal percentualDesconto;
    private @NotNull @Future LocalDate validade;

    @Deprecated
    public CupomAplicado(){}

    public CupomAplicado(Cupom cupom) {
        this.cupom = cupom;
        this.percentualDesconto = cupom.getPercentualDesconto();
        this.validade = cupom.getValidade();
    }

    public Cupom getCupom() {
        return cupom;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto.divide(new BigDecimal(100));
    }



}
