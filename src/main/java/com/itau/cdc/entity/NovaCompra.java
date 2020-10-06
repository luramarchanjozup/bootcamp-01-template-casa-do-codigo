package com.itau.cdc.entity;

import java.util.function.Function;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class NovaCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nome", nullable = false)
	@NotBlank
	private String nome;

	@Column(name="sobrenome", nullable = false)
	@NotBlank
	private String sobrenome;

	@Column(name="cpfCnpj", nullable = false)
	@NotBlank
	private String cpfCnpj;
	
	@Email
	@NotBlank
	@Column(name="email", nullable = false)
	private String email;

	@Column(name="endereco", nullable = false)
	@NotBlank
	private String endereco;

	@Column(name="complemento", nullable = true)
	private String complemento;	

	@Column(name="cep", nullable = false)
	@NotBlank
	private String cep;

	@Column(name="cidade", nullable = false)
	@NotBlank
	private String cidade;

	@ManyToOne(targetEntity = Pais.class)
	@NotNull
	private Pais pais;

	@ManyToOne(targetEntity = Estado.class)
	private Estado estado;

	@Column(name="telefone", nullable = false)
	@NotBlank
	private String telefone;
	
	@OneToOne(mappedBy = "compra",cascade = CascadeType.PERSIST)
	public PedidoCompra pedido;

	public NovaCompra(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String cpfCnpj,
			@Email @NotBlank String email, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cep, @NotBlank String cidade, Pais pais, Estado estado, @NotBlank String telefone, @Valid Function<NovaCompra, PedidoCompra> funcaoCriacaoPedido) {
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
		this.telefone=telefone;
		this.pedido=funcaoCriacaoPedido.apply(this);
	}

	public NovaCompra() {
		super();
	}

	public Long getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}
	
}
