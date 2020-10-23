package com.guiferrini.CasaCodigo.model;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FluxoPagtoDTO {

	@NotBlank(message = "Email é obrigatorio")
	@Email
	private String email;
	
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	
	@NotBlank(message = "Sobrenome é obrigatorio")
	private String sobrenome;
	
	@NotBlank(message = "Documento é obrigatorio")
	private String documento;
	
	@NotBlank(message = "Endereço é obrigatorio")
	private String endereco;
	
	@NotBlank(message = "Complemento é obrigatorio")
	private String complemento;
	
	@NotBlank(message = "Cidade é obrigatorio")
	private String cidade;
	
	@NotNull(message = "Pais é obrigatorio")
	@IdUnico(domainClass = Pais.class, fieldName="id", message = "ID do Pais é obrigatorio.")
	private String idPais;
	
	@IdUnico(domainClass = Estado.class, fieldName="id", message = "ERRO. Favor verificar o ID do Estado.")
	private String idEstado;
	
	@NotBlank(message = "Telefone é obrigatorio")
	private String telefone;
	
	@NotBlank(message = "CEP é obrigatorio")
	private String cep;
	
	@NotNull(message = "O pedido não pode ser Nulo")
	@Valid //faz a validação de outra 'tabela', td q vai p o pedido vaz uma validação aqui.
	private PedidoDTO pedido; 
	
	@IdUnico(domainClass = Cupon.class, fieldName = "id", message = "ERRO. Favor verificar o ID do Cupom.")
	@Valid
	private String idCupon;

	public FluxoPagtoDTO(@NotBlank(message = "Email é obrigatorio") @Email String email,
			@NotBlank(message = "Nome é obrigatorio") String nome,
			@NotBlank(message = "Sobrenome é obrigatorio") String sobrenome,
			@NotBlank(message = "Documento é obrigatorio") String documento,
			@NotBlank(message = "Endereço é obrigatorio") String endereco,
			@NotBlank(message = "Complemento é obrigatorio") String complemento,
			@NotBlank(message = "Cidade é obrigatorio") String cidade,
			@NotNull(message = "Pais é obrigatorio") String idPais, String idEstado,
			@NotBlank(message = "Telefone é obrigatorio") String telefone,
			@NotBlank(message = "CEP é obrigatorio") String cep,
			PedidoDTO pedido) {
		super();
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

	public String getPais() {
		return idPais;
	}

	public void setPais(String idPais) {
		this.idPais = idPais;
	}

	public String getEstado() {
		return idEstado;
	}

	public void setEstado(String idEstado) {
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
	
	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	
	public Optional<String> getIdCupon(){
		return Optional.ofNullable(idCupon);
	}

	public void setIdCupon(String idCupon) {
		this.idCupon = idCupon;
	}

	public FluxoPagto toModel(EntityManager entityManager) {

		@NotNull Pais pais =  entityManager.find(Pais.class, idPais);
		Estado estado = entityManager.find(Estado.class, idEstado);
		Pedido listaPedido = pedido.toModel(entityManager); 
		//1
		FluxoPagto fluxoPagto = new FluxoPagto(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep, listaPedido);
		//1
		if(idCupon != null) {
			Cupon cupon = entityManager.find(Cupon.class, idCupon);
			fluxoPagto.cuponSendoAplicado(cupon);
		}
		
		return fluxoPagto;
	}
}
