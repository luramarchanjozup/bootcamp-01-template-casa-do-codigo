package br.com.casacodig.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


//Contagem de Pontos - TOTAL:5
//1 - Pais
//1 - Estado
//1 - Carrinho
//1 - Cupom
//1 - If

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	@NotBlank @Email 
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@OneToOne @NotNull
	private Pais pais;
	@OneToOne @NotNull
	private Estado estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@ManyToOne(cascade = {CascadeType.ALL}) @NotNull
	private Carrinho carrinho;
	@ManyToOne
	private Cupom cupom;
	
	@Deprecated
	public Compra() {
	}
	
	public Compra(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, @NotNull Estado estado, @NotBlank String telefone,
			@NotBlank String cep, @NotNull Carrinho carrinho) {
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
		this.carrinho = carrinho;
	}
	
	public Compra(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, @NotNull Estado estado, @NotBlank String telefone,
			@NotBlank String cep, @NotNull Carrinho carrinho, Cupom cupom) {
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
		this.carrinho = carrinho;
		this.cupom = cupom;
	}
	
	public void aplicaCupom() {
		//if (this.cupom.getPercdesconto() != null) {
		if (this.cupom != null) {
			this.carrinho.atualizaValor(this.cupom.getPercdesconto());
		}
	}
	

	public Long getId() {
		return id;
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

	public String getDocumento() {
		return documento;
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

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}
	
	

	public Cupom getCupom() {
		return cupom;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", pais=" + pais + ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + ", carrinho="
				+ carrinho + ", cupom=" + cupom + "]";
	}


	
}
