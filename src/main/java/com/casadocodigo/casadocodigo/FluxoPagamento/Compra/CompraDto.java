package com.casadocodigo.casadocodigo.FluxoPagamento.Compra;

import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;

import com.casadocodigo.casadocodigo.Cupom.Cupom;
import com.casadocodigo.casadocodigo.Cupom.CupomRepository;
import com.casadocodigo.casadocodigo.Estado.Estado;
import com.casadocodigo.casadocodigo.FluxoPagamento.Pedido.Pedido;
import com.casadocodigo.casadocodigo.FluxoPagamento.Pedido.PedidoDto;
import com.casadocodigo.casadocodigo.Pais.Pais;
import com.casadocodigo.casadocodigo.Validation.ConfirmarExistencia;

public class CompraDto {

	private @Email @NotBlank String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @NotBlank String documento;
	private @NotBlank String endereco;
	private @NotBlank String complemento;
	private @NotBlank String cidade;
	private @NotNull @ConfirmarExistencia(classe = Pais.class, campo = "id") Long idPais;
	private @NotNull @ConfirmarExistencia(classe = Estado.class, campo = "id") Long idEstado;
	private @NotBlank String telefone;
	private @NotBlank String cep;
	private @NotNull @Valid PedidoDto pedido;
	private String codigoCupom;

	public Compra toModel(EntityManager manager, CupomRepository cupomRepository) {

		Pais pais = manager.find(Pais.class, idPais);

		Function<Compra, Pedido> obterPedido = pedido.toModel(manager);

		Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone,
				cep, obterPedido);
		if (idEstado != null) {
			compra.setEstado(manager.find(Estado.class, idEstado));
		}
		if (StringUtils.hasText(codigoCupom)) {
			Cupom cupom = cupomRepository.findByCodigo(codigoCupom);
			compra.aplicarCupom(cupom);
		}
		return compra;
	}

	public boolean documentoValido() {
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
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

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
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

	public PedidoDto getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
	}

	public Optional<String> getCodigoCupom() {
		return Optional.ofNullable(codigoCupom);
	}

	public void setCodigoCupom(String codigoCupom) {
		this.codigoCupom = codigoCupom;
	}
}