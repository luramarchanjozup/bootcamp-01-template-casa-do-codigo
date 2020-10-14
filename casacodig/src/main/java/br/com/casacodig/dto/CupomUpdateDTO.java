package br.com.casacodig.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

//Contagem de Pontos - TOTAL:0

public class CupomUpdateDTO {

	@NotBlank 
	private String codigo;
	@NotNull @Positive
	private BigDecimal percdesconto;
	@NotNull @Future @DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date validade;
	
	
	public CupomUpdateDTO(@NotBlank String codigo, @NotNull @Positive BigDecimal percdesconto, @NotNull @Future Date validade) {
		super();
		this.codigo = codigo;
		this.percdesconto = percdesconto;
		this.validade = validade;
	}


	public String getCodigo() {
		return codigo;
	}


	public BigDecimal getPercdesconto() {
		return percdesconto;
	}


	public Date getValidade() {
		return validade;
	}


	@Override
	public String toString() {
		return "CupomUpdateDTO [codigo=" + codigo + ", percdesconto=" + percdesconto + ", validade=" + validade + "]";
	}
	
}
