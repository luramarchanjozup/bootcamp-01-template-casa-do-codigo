package com.guiferrini.CasaCodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class CuponAplicado {

	@Valid
	@ManyToOne //(fetch = FetchType.EAGER) //ele pega td q eu faço...
	private Cupon cupon;
	
	@NotNull(message = "A porcentagem do Desconto é obrigatoria e positiva.")
	@Positive
	private BigDecimal descontoCupon;
	
	@NotNull(message = "A Data é Obrigatórioa e no Futuro.")
	@Future
	private LocalDate validadeCupon;
	
	@Deprecated 
	public CuponAplicado() {
	}

	public CuponAplicado(Cupon cupon) {
		super();
		this.cupon = cupon;
		this.descontoCupon = cupon.getDesconto();
		this.validadeCupon = cupon.getValidade();
	}

	public Cupon getCupon() {
		return cupon;
	}

	public BigDecimal getDescontoCupon() {
		return descontoCupon;
	}
	
	public LocalDate getValidadeCupon() {
		return validadeCupon;
	}
}
