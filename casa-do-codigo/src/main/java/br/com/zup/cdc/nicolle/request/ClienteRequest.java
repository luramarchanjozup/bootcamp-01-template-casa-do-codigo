package br.com.zup.cdc.nicolle.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.cdc.nicolle.model.Cliente;
import br.com.zup.cdc.nicolle.validadores.CPFCNPJ;

public class ClienteRequest {
	
	@NotBlank @Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank @CPFCNPJ
	private String documento;
	@NotBlank @Size(max = 400)
	private String endereco;
	@NotBlank @Size(max = 300)
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String pais;
	@NotBlank
	private String estado;
	@NotBlank @Size(max = 13)
	private String telefone;
	@NotBlank @Size(max = 8)
	private String cep;
	
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
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
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
	
	public Cliente novoCliente() {
		
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, estado, pais, telefone, cep, cidade);
	}
	
	
	
	
	

}
