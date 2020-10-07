package com.itau.cdc.DTO;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CupomResponse {

	private Long id;
	
	@NotBlank
	private String codigo;

	@NotNull
	@Positive
	@JsonProperty("percentual_desconto")
	private BigDecimal percentualDesconto;

	public CupomResponse(Long id, @NotBlank String codigo, @NotNull @Positive BigDecimal percentualDesconto) {
		super();
		this.id=id;
		this.codigo=codigo;
		this.percentualDesconto=percentualDesconto;
	}

	public String getCodigo() {
		return codigo;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public Long getId() {
		return id;
	}

	

}
