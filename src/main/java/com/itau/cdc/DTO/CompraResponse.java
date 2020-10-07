package com.itau.cdc.DTO;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.Estado;
import com.itau.cdc.entity.Pais;

public class CompraResponse {

	@Email
	@NotBlank
	@JsonProperty("email")
	private String email;
	
	@NotBlank
	@JsonProperty("nome")
	private String nome;
	
	@NotBlank
	@JsonProperty("sobrenome")
	private String sobrenome;
	
	@NotBlank
	@JsonProperty("documento")
	private String cpfCnpj;
	
	@NotBlank
	@JsonProperty("endereco")
	private String endereco;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("complemento")
	private String complemento;
	
	@NotBlank
	@JsonProperty("cidade")
	private String cidade;
	
	@NotNull
	@JsonProperty("pais")
	private Pais pais;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("estado")
	private Estado estado;
	
	@NotBlank
	@JsonProperty("telefone")
	private String telefone;
	
	@NotBlank
	@JsonProperty("cep")
	private String cep;
	
	@Valid
	private PedidoCompraResponse pedido;

	public CompraResponse(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String cpfCnpj,
			@Email @NotBlank String email, @NotBlank String endereco, String complemento, @NotBlank String cep,
			@NotBlank String cidade, Estado estado, @NotNull Pais pais, @NotBlank String telefone,
			PedidoCompraResponse pedido) {
		super();
		this.nome=nome;
		this.sobrenome=sobrenome;
		this.cpfCnpj=cpfCnpj;
		this.email=email;
		this.endereco=endereco;
		this.complemento=complemento;
		this.cep=cep;
		this.cidade=cidade;
		this.estado=estado;
		this.pais=pais;
		this.estado=estado;
		this.telefone=telefone;
		this.pedido=pedido;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getIdPais() {
		return pais;
	}

	public Estado getIdEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
	public PedidoCompraResponse getPedido() {
		return pedido;
	}
	
}
