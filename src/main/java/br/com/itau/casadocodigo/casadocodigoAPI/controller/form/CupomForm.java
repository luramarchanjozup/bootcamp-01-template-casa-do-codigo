package br.com.itau.casadocodigo.casadocodigoAPI.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.CupomUtilizavel;
import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.UniqueValue;
import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.VerificaExistenciaTuplaRelacao;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Cupom;

public class CupomForm {

	@NotBlank
	// 1
	@UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
	private String codigo;
	@NotNull
	@Positive
	private double percentualDesconto;
	@Future
	private LocalDate dataValidade;

	public Cupom converter() {

		return new Cupom(this.codigo, this.percentualDesconto, this.dataValidade);
	}

	// 1
	public Cupom alterarCupom(Cupom cupom) {

		cupom.setCodigo(this.codigo);
		cupom.setPercentualDesconto(this.percentualDesconto);
		cupom.setDataValidade(this.dataValidade);

		return cupom;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

}
