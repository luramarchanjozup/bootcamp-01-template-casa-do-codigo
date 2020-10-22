package com.guiferrini.CasaCodigo.model;

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
	private Double desconto;
	
	@NotNull(message = "A Data é Obrigatórioa e no Futuro.")
	@Future
	private LocalDate date;
	
	@Deprecated
	public Cupon() {
	}

	public Cupon(@NotBlank(message = "O Código é Obrigatorio.") String codigo, 
			@NotNull(message = "A porcentagem do Desconto é obrigatoria e positiva.") @Positive Double desconto, 
			@NotNull(message = "A Data é Obrigatórioa e no Futuro.") @Future LocalDate date) {
		super();
		this.codigo = codigo;
		this.desconto = desconto;
		this.date = date;
	}
	
	public String toString() {
		return "Cupon: Código: " +
				codigo +
				" Porcentagem de Desconto: " +
				desconto + 
				" Data de Validade: " + 
				date;
	}
}
