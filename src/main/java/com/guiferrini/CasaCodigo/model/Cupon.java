package com.guiferrini.CasaCodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cupon")
public class Cupon {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@NotBlank(message = "O Código é Obrigatorio.")
	//criar validador de duplicidade
	private String codigo;
	
	@NotNull(message = "A porcentagem do Desconto é obrigatoria e positiva.")
	@Positive
	private BigDecimal desconto;
	
	@NotNull(message = "A Data é Obrigatórioa e no Futuro.")
	@Future
	private LocalDate validade;
	
	@Deprecated
	public Cupon() {
	}

	public Cupon(@NotBlank(message = "O Código é Obrigatorio.") String codigo, 
			@NotNull(message = "A porcentagem do Desconto é obrigatoria e positiva.") @Positive BigDecimal desconto, 
			@NotNull(message = "A Data é Obrigatórioa e no Futuro.") @Future LocalDate validade) {
		super();
		this.codigo = codigo;
		this.desconto = desconto;
		this.validade = validade;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	
	public String getId() {
		return id;
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
	
	public boolean cuponDataValida() {
		return LocalDate.now().compareTo(this.validade) <= 0;
	}	

	public String toString() {
		return "Cupon: Código: " +
				codigo +
				" Porcentagem de Desconto: " +
				desconto + 
				" Data de Validade: " + 
				validade;
	}
}
