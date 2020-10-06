package com.itau.cdc.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Cupom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String codigo;
	
	@NotNull
	@Positive
	private BigDecimal percentual;
	
	@NotNull
	private Date validade;

	public Cupom() {
		super();
	}

	public Cupom(String codigo, @NotNull @Positive BigDecimal percentual, Date validade) {
		super();
		this.codigo = codigo;
		this.percentual = percentual;
		this.validade = validade;
	}
	
	public void AlteraIdCupom(Optional<Cupom> cupomNaBase) {
		this.id = cupomNaBase.get().getId();
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public Date getValidade() {
		return validade;
	}

	public String getCodigo() {
		return codigo;
	}
	
	
}
