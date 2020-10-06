package com.itau.cdc.DTO;

import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.cdc.entity.Estado;
import com.itau.cdc.entity.NovaCompra;
import com.itau.cdc.entity.Pais;
import com.itau.cdc.entity.PedidoCompra;
import com.itau.cdc.validator.ValidaCpfCnpj;

public class CompraRequest {

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
	
	@JsonProperty("complemento")
	private String complemento;
	
	@NotBlank
	@JsonProperty("cidade")
	private String cidade;
	
	@NotNull
	@JsonProperty("id_pais")
	private Long idPais;

	@JsonProperty("id_estado")
	private Long idEstado;
	
	@NotBlank
	@JsonProperty("telefone")
	private String telefone;
	
	@NotBlank
	@JsonProperty("cep")
	private String cep;
	
	@Valid
	private PedidoCompraRequest pedido;

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

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
	public PedidoCompraRequest getPedido() {
		return pedido;
	}
	
	@Autowired
	private ValidaCpfCnpj validaCpfCnpj = new ValidaCpfCnpj();
	
	public NovaCompra toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		if(pais==null) {
			throw new IllegalArgumentException("País não cadastrado.");
		}
		
		Estado estado;
		if(idEstado != null && idEstado != 0) {
			estado = manager.find(Estado.class, idEstado);
			if(estado==null) {
				throw new IllegalArgumentException("Estado não cadastrado.");
			}
			
			if(pais.getId() != estado.getPais().getId()) {
				throw new IllegalArgumentException("Estado não pertence ao País.");
			}
		}else {
			estado = null;
		}
		
		if(!validaCpfCnpj.validaCpfCnpj(cpfCnpj)) {
			throw new IllegalArgumentException("Documento (CPF ou CNPJ) não é válido.");
		}
		
		Function<NovaCompra, PedidoCompra> funcaoCriacaoPedido = pedido.toModel(manager);
		
		
		return new NovaCompra(nome, sobrenome, cpfCnpj, email, endereco, complemento, cep, cidade, pais, estado, telefone, funcaoCriacaoPedido);
	}

	
	
}
