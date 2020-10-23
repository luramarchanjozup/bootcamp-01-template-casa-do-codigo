package br.com.zup.casadocodigo.cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.validacao.ValorUnico;

//2
public class CupomDTO {

	// 1
	// 1
	@NotBlank
	@ValorUnico(classeDominio = Cupom.class, nomeCampo = "codigo")
	private String codigo;

	@Positive
	@NotNull
	private BigDecimal percentualDesconto;

	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate validade;

	public CupomDTO(@NotBlank String codigo, @Positive @NotNull BigDecimal percentualDesconto) {
		this.codigo = codigo;
		this.percentualDesconto = percentualDesconto;

	}

	public Cupom gerarNovoCupom() {
		Cupom novoCupom = new Cupom(codigo, percentualDesconto, validade);
		return novoCupom;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public String getCodigo() {
		return codigo;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public Cupom gerarCupomAtualizado() {
		Cupom atualizeCupom = new Cupom(codigo, percentualDesconto, validade);
		return atualizeCupom;
	}

}
