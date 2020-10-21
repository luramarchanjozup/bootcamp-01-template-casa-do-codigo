package br.com.itau.casadocodigo.cadastrocliente.model;

import br.com.itau.casadocodigo.cadastrocupom.model.Cupom;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CupomDesconto {

    @NotNull
    @Positive
    private BigDecimal percentualDesconto;
    @NotBlank
    @Future
    private LocalDate validadeDesconto;
    @ManyToOne
    private Cupom cupom;

    @Deprecated
    public CupomDesconto() {
    }

    public CupomDesconto(@NotNull @Positive BigDecimal percentualDesconto, @NotBlank @Future LocalDate validadeDesconto) {
        this.percentualDesconto = percentualDesconto;
        this.validadeDesconto = validadeDesconto;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public LocalDate getValidadeDesconto() {
        return validadeDesconto;
    }

    public Cupom getCupom() {
        return cupom;
    }
}
