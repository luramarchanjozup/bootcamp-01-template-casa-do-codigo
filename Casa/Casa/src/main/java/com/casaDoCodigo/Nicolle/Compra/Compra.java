package com.casaDoCodigo.Nicolle.Compra;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.casaDoCodigo.Nicolle.Cupom.Cupom;
import com.casaDoCodigo.Nicolle.Estado.Estado;
import com.casaDoCodigo.Nicolle.Pais.Pais;
import com.casaDoCodigo.Nicolle.Validadores.CPFCNPJ;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private @NotBlank @Email String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @NotBlank @CPFCNPJ String documento;
	private @NotBlank @Size(max = 400) String endereco;
	private @NotBlank @Size(max = 350) String complemento;
	private @NotBlank String cep;
	private @ManyToOne Estado estado;
	private @ManyToOne Pais pais;
	
	private @ElementCollection @Size(min = 1) Set<ItemCompra> itens = new HashSet<>();
	private @PastOrPresent LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne (optional = true)
	private Cupom cupom;
	
	//@ManyToOne // Gui: Nao vejo usabilidade desta anotacao
	private BigDecimal totalComDesconto;
	
	@Deprecated
	public Compra() {}

	public Compra(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank @Size(max = 400) String endereco,
			@NotBlank @Size(max = 350) String complemento, @NotBlank String cep, Estado estado, Pais pais,
			@Size(min = 1) Set<ItemCompra> itens) {
				this.email = email;
				this.nome = nome;
				this.sobrenome = sobrenome;
				this.documento = documento;
				this.endereco = endereco;
				this.complemento = complemento;
				this.cep = cep;
				this.estado = estado;
				this.pais = pais;
				this.itens.addAll(itens);	
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Set<ItemCompra> getItens() {
		return itens;
	}

	public void setItens(Set<ItemCompra> itens) {
		this.itens = itens;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
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

	public BigDecimal getTotalComDesconto() {
		return totalComDesconto;
	}
	
	public void setTotalComDesconto(BigDecimal totalComDesconto) {
		this.totalComDesconto = totalComDesconto;
	}
	
	public Cupom getCupom() {
		return cupom;
	}
	

	@Override
	public String toString() {
		return "Compra [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cep=" + cep + ", estado="
				+ estado + ", pais=" + pais + ", itens=" + itens + ", createdAt=" + createdAt + ", cupom=" + cupom +"]";
	}

	public void setCupom(Cupom cupom) {
		Assert.isTrue(cupom.taValido(), "Este cupom está invalido, favor verificar validade");
		this.cupom = cupom;
	}



	
}
