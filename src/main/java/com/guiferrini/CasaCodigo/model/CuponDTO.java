package com.guiferrini.CasaCodigo.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class CuponDTO {

	@NotBlank(message = "O Código é Obrigatorio.")
	private String codigo;
	
	@NotNull(message = "A porcentagem do Desconto é obrigatoria e positiva.")
	@Positive
	private Double desconto;
	
	@NotNull(message = "A Data é Obrigatórioa e no Futuro.")
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate validade;
	
	@Deprecated
	public CuponDTO() {
	}

	public CuponDTO(@NotBlank(message = "O Código é Obrigatorio.") String codigo, 
			@NotNull(message = "A porcentagem do Desconto é obrigatoria e positiva.") @Positive Double desconto, 
			@NotNull(message = "A Data é Obrigatórioa e no Futuro.") @Future LocalDate validade) {
		super();
		this.codigo = codigo;
		this.desconto = desconto;
		this.validade = validade;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public Double getDesconto() {
		return desconto;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public Cupon toModel() {
		//return new Cupon(codigo, desconto, date);
		Cupon obj = new Cupon(codigo, desconto, validade);
		return obj;
	}
}
