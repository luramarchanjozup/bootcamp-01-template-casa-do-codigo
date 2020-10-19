package br.com.casacodig.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


//CupomRepository de Pontos - TOTAL:0

@Entity
public class Cupom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank 
	private String codigo;
	@NotNull @Positive
	private BigDecimal percdesconto;
	@NotNull @Future
	private Date validade;
	
	@Deprecated
	public Cupom() {
	}
	
	public Cupom(@NotBlank String codigo, @NotNull @Positive BigDecimal percdesconto, @NotNull @Future Date validade) {
		this.codigo = codigo;
		this.percdesconto = percdesconto;
		this.validade = validade;
	}
	
	public Cupom(Long id, @NotBlank String codigo, @NotNull @Positive BigDecimal percdesconto, @NotNull @Future Date validade) {
		this.id = id;
		this.codigo = codigo;
		this.percdesconto = percdesconto;
		this.validade = validade;
	}
	
	public boolean validaData() {
		Date dataAtual = new Date();	
		DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); 
		String dataformatadaSistema = formatoData.format(dataAtual);
		String dataFormatadaCupom = formatoData.format(this.validade);
		int resultado = dataformatadaSistema.compareTo(dataFormatadaCupom);
		return resultado <= 0;
	}

	
	public Long getId() {
		return id;
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
	
	

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPercdesconto(BigDecimal percdesconto) {
		this.percdesconto = percdesconto;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	@Override
	public String toString() {
		return "Cupom [id=" + id + ", codigo=" + codigo + ", percdesconto=" + percdesconto + ", validade=" + validade
				+ "]";
	}
	
	
	
	
	
}
