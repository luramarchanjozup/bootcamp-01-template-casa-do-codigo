package br.com.zup.casadocodigo.novacompra;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.zup.casadocodigo.paisestado.Estado;
import br.com.zup.casadocodigo.paisestado.Pais;
import br.com.zup.casadocodigo.validacao.IdExiste;

public class NovaCompraDTO {

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

	@NotBlank
	private String cidade;

	@NotNull
	@IdExiste(domainClass = Pais.class, fieldName = "idPais")
	private Integer idPais;

	@IdExiste(domainClass = Estado.class, fieldName = "idEstado")
	private Integer idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	private CarrinhoCompraDTO pedido;

	public NovaCompraDTO(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Integer idPais, Integer idEstado, @NotBlank String telefone,
			@NotBlank String cep, @Valid @NotNull CarrinhoCompraDTO pedido) {

		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
		this.pedido = pedido;

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

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public CarrinhoCompraDTO getPedido() {
		return pedido;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public boolean documentoValido() {
		Assert.hasLength(documento, "você nao deveria validar o documento se ele não tiver sido preenchido");

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
	}

	public Compra gerarNovaCompra(EntityManager bancoDados) {

		@NotNull
		Pais buscaPais = bancoDados.find(Pais.class, idPais);

		Compra novaCompra = new Compra(email, nome, sobrenome, documento, endereco, complemento, buscaPais, telefone,
				cep);
		if (idEstado != null) {
			Estado buscaEstado = bancoDados.find(Estado.class, idEstado);
			novaCompra.setEstado(buscaEstado);
		}

		return novaCompra;

	}

	public boolean temEstado() {
		return idEstado != null;

	}

}
