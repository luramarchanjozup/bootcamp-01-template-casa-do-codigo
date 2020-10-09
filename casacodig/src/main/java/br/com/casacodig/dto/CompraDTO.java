package br.com.casacodig.dto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.sun.istack.Nullable;

import br.com.casacodig.model.Carrinho;
import br.com.casacodig.model.Compra;
import br.com.casacodig.model.Cupom;
import br.com.casacodig.model.Estado;
import br.com.casacodig.model.Pais;
import br.com.casacodig.validator.CupomValido;
import br.com.casacodig.validator.DocumentoValido;
import br.com.casacodig.validator.IdExistente;


//Contagem de Pontos - TOTAL:7
//1 - Pais
//1 - Estado
//1 - CarrinhoDTO
//1 - Carrinho
//2 - If
//1 - Cupom


public class CompraDTO {

	@NotBlank @Email 
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank @DocumentoValido(campo = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull @IdExistente(classe = "Pais", campo = "id")
	private Long idPais;
	@NotNull @IdExistente(classe = "Estado", campo = "id")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@Valid 
	private CarrinhoDTO carrinhodto;
	@CupomValido(campo = "codigo") 
	private String codigoCupom;
	
	
	public CompraDTO(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, @NotNull Long idEstado, @NotBlank String telefone,
			@NotBlank String cep, @Valid CarrinhoDTO carrinhodto) {
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
		this.carrinhodto = carrinhodto;
	}
	
	public String getCodigoCupom() {
		return codigoCupom;
	}



	public void setCodigoCupom(String codigoCupom) {
		this.codigoCupom = codigoCupom;
	}


	public CarrinhoDTO getCarrinhodto() {
		return carrinhodto;
	}

	public Compra toModel(EntityManager manager){
		@NotNull Pais pais = manager.find(Pais.class, this.idPais);
		@NotNull Estado estado = manager.find(Estado.class, this.idEstado);
		Cupom cupom = new Cupom();
		
		Carrinho carrinho = carrinhodto.toModel(manager);
		if (estado.getPais() != pais) {
			estado = null;
		}
		
		if(this.codigoCupom != "" && this.codigoCupom != null) {
			Query query = manager.createQuery("select c from Cupom c where codigo = :value");
			query.setParameter("value", this.codigoCupom);
			cupom = (Cupom) query.getSingleResult();
			return new Compra(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, pais, 
					estado, this.telefone, this.cep, carrinho, cupom);
		}		
		return new Compra(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, pais, 
				estado, this.telefone, this.cep, carrinho);
	}

	@Override
	public String toString() {
		return "CompraDTO [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", idPais="
				+ idPais + ", idEstado=" + idEstado + ", telefone=" + telefone + ", cep=" + cep + ", carrinhodto="
				+ carrinhodto + ", codigoCupom=" + codigoCupom + "]";
	}

	
	
	
	
	
}
