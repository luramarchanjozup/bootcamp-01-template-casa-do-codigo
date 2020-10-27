package com.casadocodigo.casadocodigo.Cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

@Entity
public class Cupom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String codigo;
	private @NotNull @Positive BigDecimal desconto;
	private @NotNull LocalDate validade;

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public String getCodigo() {
		return codigo;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public LocalDate getValidade() {
		return validade;
	}

	@Deprecated
	public Cupom() {

	}

	public Cupom(@NotBlank String codigo, BigDecimal desconto, @Future LocalDate validade) {
		super();
		this.codigo = codigo;
		this.desconto = desconto;
		this.validade = validade;
	}

	public boolean verificaValidade() {
		return LocalDate.now().compareTo(this.validade) <= 0;
	}

	@Override
	public String toString() {
		return "Cupom [id=" + id + ", codigo=" + codigo + ", desconto=" + desconto + ", validade=" + validade + "]";
	}

}
