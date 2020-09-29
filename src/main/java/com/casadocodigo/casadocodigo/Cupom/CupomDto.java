package com.casadocodigo.casadocodigo.Cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.casadocodigo.casadocodigo.Validation.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

public class CupomDto {

	private @NotBlank @ValorUnico(campo = "codigo", classe = Cupom.class) String codigo;
	private @NotNull @Positive BigDecimal desconto;
	private @Future @NotNull @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING) LocalDate validade;

	public String getCodigo() {
		return codigo;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public CupomDto(@NotBlank String codigo, @NotNull BigDecimal desconto, @NotNull LocalDate validade) {
		super();
		this.codigo = codigo;
		this.desconto = desconto;
		this.validade = validade;
	}

	public Cupom toModel() {
		return new Cupom(codigo, desconto, validade);
	}

}
