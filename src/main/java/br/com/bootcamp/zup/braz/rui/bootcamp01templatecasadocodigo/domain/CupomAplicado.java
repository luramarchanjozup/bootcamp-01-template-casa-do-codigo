package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Embeddable
public class CupomAplicado {

    @ManyToOne
    private Cupom cupom;

    @Positive
    @NotNull
    private Integer percentualDesconto;
    @NotNull
    @Future
    private LocalDate validadeCupom;

    @Deprecated
    public CupomAplicado(){

    }

    public CupomAplicado(Cupom cupom) {
        this.cupom = cupom;
        this.percentualDesconto = cupom.getDesconto();
        this.validadeCupom = cupom.getValidade();
    }

    public Cupom getCupom() {
        return cupom;
    }
}
