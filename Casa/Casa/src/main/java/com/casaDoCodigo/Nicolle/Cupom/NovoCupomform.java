package com.casaDoCodigo.Nicolle.Cupom;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.casaDoCodigo.Nicolle.Validadores.MinhaAnotacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class NovoCupomform {
	
	@NotBlank
	@MinhaAnotacao(dominioClasse = Cupom.class, nomeCampo = "codigo")
	private String codigo;
	
	@Future
	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy kk:mm")
	@NotNull
	private LocalDateTime validade;
	
	@Positive
	@DecimalMin("0.01")
	private BigDecimal desconto;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getValidade() {
		return validade;
	}

	public void setValidade(LocalDateTime validade) {
		this.validade = validade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Cupom novoCupom() {
		return new Cupom(codigo,validade,desconto);
	}
	
	
}
