package br.com.zup.casadocodigo.cupom;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Cupom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String codigo;

	@Positive
	@NotNull
	private BigDecimal percentualDesconto;

	@NotNull
	@Future
	private LocalDate validade;

	public Cupom(@NotBlank String codigo, @Positive @NotNull BigDecimal percentualDesconto,
			@NotNull @Future LocalDate validade) {
		this.codigo = codigo;
		this.percentualDesconto = percentualDesconto;
		this.validade = validade;
	}

	public Integer getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public String getValidade() {
		return validade.format(ofPattern("dd/MM/yyyy"));
	}

}
