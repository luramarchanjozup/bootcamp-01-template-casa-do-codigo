package com.guiferrini.CasaCodigo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="fluxopagto")
public class FluxoPagto {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(generator = "UUID", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
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
	
	@ManyToOne
	@NotNull(message = "Pais é obrigatorio")
	private Pais pais;
	
	//@NotBlank(message = "Se tem um Pais, o Estado é obrigatorio")
	@ManyToOne
	private Estado estado;
	
	@NotBlank(message = "Telefone é obrigatorio")
	private String telefone;
	
	@NotBlank(message = "CEP é obrigatorio")
	private String cep;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL) 
	@NotNull
	private Pedido pedido;
	
	public FluxoPagto(@NotBlank(message = "Email é obrigatorio") @Email String email,
			@NotBlank(message = "Nome é obrigatorio") String nome,
			@NotBlank(message = "Sobrenome é obrigatorio") String sobrenome,
			@NotBlank(message = "Documento é obrigatorio") String documento,
			@NotBlank(message = "Endereço é obrigatorio") String endereco,
			@NotBlank(message = "Complemento é obrigatorio") String complemento,
			@NotBlank(message = "Cidade é obrigatorio") String cidade,
			@NotBlank(message = "Pais é obrigatorio") Pais pais,
			Estado estado,
			@NotBlank(message = "Telefone é obrigatorio") String telefone,
			@NotBlank(message = "CEP é obrigatorio") String cep,
			@NotNull Pedido pedido
			) {
		super();
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
		this.pedido = pedido;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
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
	
	@Override
	public String toString() {
		return "Compra [email=" + 
				email + 
				", nome= " + 
				nome + 
				", sobrenome= "+ 
				sobrenome + 
				", documento= " + 
				documento + 
				", endereco= " + 
				endereco + 
				", complemento= " + 
				complemento + 
				", pais= " + 
				pais + 
				", telefone= " + 
				telefone + 
				", cep= " + 
				cep + 
				", estado= " + 
				estado + 
				", pedido= " + 
				pedido + 
				"]";
	}
}
