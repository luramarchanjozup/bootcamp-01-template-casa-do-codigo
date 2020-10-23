package com.guiferrini.CasaCodigo.model;

import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class CuponAplicado {

	@Valid
	@ManyToOne //(fetch = FetchType.EAGER)
	private Cupon cupon;
	
	@NotNull(message = "A porcentagem do Desconto é obrigatoria e positiva.")
	@Positive
	private Double descontoCupon;
	
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
}
