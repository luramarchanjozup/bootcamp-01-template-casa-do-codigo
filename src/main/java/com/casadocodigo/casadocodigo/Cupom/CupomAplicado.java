package com.casadocodigo.casadocodigo.Cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

@Embeddable
public class CupomAplicado {

	@ManyToOne
	private Cupom cupom;
	private @Positive @NotNull BigDecimal desconto;
	private @NotNull @Future LocalDate validade;

	public Cupom getCupom() {
		return cupom;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public LocalDate getValidade() {
		return validade;
	}

	@Deprecated
	public CupomAplicado() {
	}

	public CupomAplicado(Cupom cupom) {
		this.cupom = cupom;
		this.desconto = cupom.getDesconto();
		this.validade = cupom.getValidade();
	}

	@Override
	public String toString() {
		return "CupomAplicado [cupom=" + cupom + ", desconto=" + desconto + ", validade=" + validade + "]";
	}

}
