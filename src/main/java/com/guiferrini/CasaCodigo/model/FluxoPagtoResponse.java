package com.guiferrini.CasaCodigo.model;

import java.math.BigDecimal;
import java.util.List;

public class FluxoPagtoResponse {

	private String email;
	
	private String nome;
	
	private String sobrenome;
	
	private String documento;
	
	private String endereco;
	
	private String complemento;
	
	private String cidade;
	
	private Pais pais;
	
	private Estado estado;

	private String telefone;
	
	private String cep;
	
	private List<ItemPedido> itens;
	
	private BigDecimal total;
	
	private BigDecimal desconto;
	
	private BigDecimal valorFinal;
	
	@Deprecated
	public FluxoPagtoResponse() {
	}

	public FluxoPagtoResponse(FluxoPagto fluxoPagto) {
		this.email = fluxoPagto.getEmail();
		this.nome = fluxoPagto.getNome();
		this.sobrenome = fluxoPagto.getSobrenome();
		this.documento = fluxoPagto.getDocumento();
		this.endereco = fluxoPagto.getEndereco();
		this.complemento = fluxoPagto.getComplemento();
		this.cidade = fluxoPagto.getCidade();
		this.pais = fluxoPagto.getPais();
		this.estado = fluxoPagto.getEstado();
		this.telefone = fluxoPagto.getTelefone();
		this.cep = fluxoPagto.getCep();
		this.itens = fluxoPagto.getPedido().getItens();
		this.total = fluxoPagto.pedidoTotal();
		this.desconto = fluxoPagto.getCuponAplicado().getDescontoCupon();
		this.valorFinal = fluxoPagto.valorFinalComDesconto();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
	
}
