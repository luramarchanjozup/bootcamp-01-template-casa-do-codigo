package com.itau.cdc.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Cupom2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String codigo;

	@NotNull
	@Positive
	private BigDecimal percentualDesconto;

	@NotNull
	private Date validade;

	public Cupom2() {
		super();
	}

	public Cupom2(String codigo, @NotNull @Positive BigDecimal percentual, Date validade) {
		super();
		this.codigo = codigo;
		this.percentualDesconto = percentual;
		this.validade = validade;
	}

	public void AlteraIdCupom(Optional<Cupom2> cupomNaBase) {
		this.id = cupomNaBase.get().getId();
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public BigDecimal getPercentualTotalParaPagamento() {
		BigDecimal um = new BigDecimal(1);
		return um.subtract(percentualDesconto.scaleByPowerOfTen(-2));
	}

	public Date getValidade() {
		return validade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void CupomValido(Cupom2 cupom, Long idCupom, EntityManager manager) {
		if(idCupom!=null) {
			 cupom = manager.find(Cupom2.class, idCupom);
			 if(cupom.getValidade().after(new Date())) {
				 throw new IllegalArgumentException("Cupom vencido.");
			 }
		}else {
			 cupom = null;
		}
	}

}
