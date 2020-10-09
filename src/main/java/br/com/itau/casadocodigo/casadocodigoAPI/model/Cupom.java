package br.com.itau.casadocodigo.casadocodigoAPI.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cupom")
public class Cupom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codigo;
	private double percentualDesconto;
	private LocalDate dataValidade;
	private LocalDate dataUtilizado;

	public Cupom(String codigo, double percentualDesconto, LocalDate dataValidade) {
		this.codigo = codigo;
		this.percentualDesconto = percentualDesconto;
		this.dataValidade = dataValidade;

	}

	@Deprecated
	public Cupom() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getDataUtilizado() {
		return dataUtilizado;
	}

	public void setDataUtilizado(LocalDate dataUtilizado) {
		this.dataUtilizado = dataUtilizado;
	}

}
