package com.itau.cdc.DTO;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itau.cdc.entity.Cupom;
import com.itau.cdc.exception.ApiErroException;

public class CupomRequest {

	@NotBlank
	private String codigo;

	@NotNull
	@Positive
	private BigDecimal percentual;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private Date validade;

	public String getCodigo() {
		return codigo;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public Date getValidade() {
		return validade;
	}

	public Cupom toModel() {
		if(!validade.after(new Date())) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Data de validade " + validade + " do cupom deve ser maior que agora.");
		}
		return new Cupom(codigo, percentual, validade);
	}

}
