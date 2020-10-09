package br.com.itau.casadocodigo.casadocodigoAPI.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "compras_detalhes")
public class NovaCompraItensCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int idLivro;
	private int quantidade;

	// 1
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "compra_id", referencedColumnName = "id")
	private NovaCompra novaCompra;

	public NovaCompraItensCarrinho(int idLivro, int quantidade, NovaCompra compra) {
		this.idLivro = idLivro;
		this.quantidade = quantidade;
		this.novaCompra = compra;
	}

	@Deprecated
	public NovaCompraItensCarrinho() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public NovaCompra getNovaCompra() {
		return novaCompra;
	}

	public void setNovaCompra(NovaCompra novaCompra) {
		this.novaCompra = novaCompra;
	}

}
