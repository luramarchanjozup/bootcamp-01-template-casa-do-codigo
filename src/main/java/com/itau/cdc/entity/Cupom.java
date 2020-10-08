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

import com.itau.cdc.DTO.CupomResponse;

@Entity
public class Cupom {

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

	public Cupom() {
		super();
	}

	public Cupom(String codigo, @NotNull @Positive BigDecimal percentual, Date validade) {
		super();
		this.codigo = codigo;
		this.percentualDesconto = percentual;
		this.validade = validade;
	}

	public void AlteraIdCupom(Optional<Cupom> cupomNaBase) {
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

	public Cupom CupomValido(Cupom cupom, Long idCupom, EntityManager manager) {
		if(idCupom!=null) {
			 cupom = manager.find(Cupom.class, idCupom);
			 if(!cupom.getValidade().after(new Date())) {
				 throw new IllegalArgumentException("Cupom vencido.");
			 }
		}else {
			 cupom = null;
		}
		return cupom;
	}

	public CupomResponse toResponse() {
		return new CupomResponse(id, codigo, percentualDesconto);
	}

}
