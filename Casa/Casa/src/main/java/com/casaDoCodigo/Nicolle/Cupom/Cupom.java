package com.casaDoCodigo.Nicolle.Cupom;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Cupom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private @NotBlank String codigo;
	private @Future @NotNull LocalDateTime validade;
	private @Positive @DecimalMin("0.01") BigDecimal desconto;

	@Deprecated
	public Cupom() {}

	public Cupom(@NotBlank String codigo, @Future @NotNull LocalDateTime validade,
			@Positive @DecimalMin("0.01") BigDecimal desconto) {
		//Assert.isTrue(desconto.compareTo(new BigDecimal("0.01")) <= 0, "Desconto não pode ser nulo, ou negativo"
		//Verificar o máximo de desconto que um cupom pode, deve ter. Assert para proteção/afirmação
				this.codigo = codigo;
				this.validade = validade;
				this.desconto = desconto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Cupom [id=" + id + ", codigo=" + codigo + ", validade=" + validade + ", desconto=" + desconto + "]";
	}

	public boolean taValido() {
		return validade.compareTo(LocalDateTime.now()) >= 0;
	}
	
	

}
