package br.com.itau.casadocodigo.casadocodigoAPI.model.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.CarrinhoComprasForm;

public class NovaCompraDTO {

	private int id;
	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	// 1
	private PaisDTO pais;
	// 1
	private EstadoDTO estado;
	private String telefone;
	private String cep;
	private BigDecimal totalItens;
	// 1
	@JsonIgnore
	private List<NovaCompraItensCarrinhoDTO> novaCompraDetalhes;
	private BigDecimal valorSemDesconto;
	private BigDecimal valorComDesconto;

	public NovaCompraDTO(String email, String nome, String sobrenome, String documento, String endereco,
			String complemento, String cidade, PaisDTO pais, EstadoDTO estado, String telefone, String cep,
			CarrinhoComprasForm carrinhoComprasForm, BigDecimal valorSemDesconto, BigDecimal valorComDesconto) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
		this.totalItens = carrinhoComprasForm.getTotal();
		this.valorComDesconto = valorComDesconto;
		this.valorSemDesconto = valorSemDesconto;
	}

	@Deprecated
	public NovaCompraDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public BigDecimal getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(BigDecimal totalItens) {
		this.totalItens = totalItens;
	}

	public List<NovaCompraItensCarrinhoDTO> getNovaCompraDetalhes() {
		return novaCompraDetalhes;
	}

	public void setNovaCompraDetalhes(List<NovaCompraItensCarrinhoDTO> novaCompraDetalhes) {
		this.novaCompraDetalhes = novaCompraDetalhes;
	}

	public BigDecimal getValorSemDesconto() {
		return valorSemDesconto;
	}

	public void setValorSemDesconto(BigDecimal valorSemDesconto) {
		this.valorSemDesconto = valorSemDesconto;
	}

	public BigDecimal getValorComDesconto() {
		return valorComDesconto;
	}

	public void setValorComDesconto(BigDecimal valorComDesconto) {
		this.valorComDesconto = valorComDesconto;
	}

}
