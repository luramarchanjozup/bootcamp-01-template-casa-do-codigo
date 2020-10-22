package br.com.zup.casadocodigo.novacompra;

import java.util.function.Function;

import javax.persistence.CascadeType;
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

import org.springframework.util.Assert;

import br.com.zup.casadocodigo.cupom.Cupom;
import br.com.zup.casadocodigo.paisestado.Estado;
import br.com.zup.casadocodigo.paisestado.Pais;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCompra;

	@Email
	@NotBlank
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

	@ManyToOne
	@NotNull
	private Pais pais;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	@ManyToOne
	private Estado estado;

	@OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST)
	private CarrinhoCompra carrinhoCompra;

	@ManyToOne
	private Cupom cupom;

	@Deprecated
	public Compra() {

	}

	public Compra(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotNull Pais pais,
			@NotBlank String telefone, @NotBlank String cep, Function<Compra, CarrinhoCompra> carrinhoCompra) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
		this.carrinhoCompra = carrinhoCompra.apply(this);

	}

	public void setEstado(@NotNull @Valid Estado estado) {
		Assert.notNull(pais, "Não rola associar um estado enquanto o pais for nulo");
		Assert.isTrue(!estado.naoPertenceAPais(pais), "Este estado não é de país associado a compra");
		this.estado = estado;
	}

	public void aplicaCupom(Cupom cupom) {
		Assert.isTrue(cupom.valido(), "Olha o cupom que está sendo aplicado não está mais válido ");
		Assert.isNull(this.cupom, "Olha você não pode trocar um cupom de uma compra");
		this.cupom = cupom;
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

	public Pais getPais() {
		return pais;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Estado getEstado() {
		return estado;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public Long getIdCompra() {
		return idCompra;
	}

}
