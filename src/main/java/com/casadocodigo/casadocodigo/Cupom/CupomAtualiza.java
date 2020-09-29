package com.casadocodigo.casadocodigo.Cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

public class CupomAtualiza {

	@NotBlank
	private String codigo;

	@NotNull
	@Positive
	private BigDecimal desconto;

	@Future
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate validade;

	public Cupom atualizarCupom(Cupom cupom) {
		cupom.setCodigo(codigo);
		cupom.setValidade(validade);
		cupom.setDesconto(desconto);
		return cupom;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

}
