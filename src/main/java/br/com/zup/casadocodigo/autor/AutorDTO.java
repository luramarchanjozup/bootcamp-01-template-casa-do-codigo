package br.com.zup.casadocodigo.autor;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.validacao.ValorUnico;

public class AutorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7522560578729490706L;

	private Integer idAutor;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@ValorUnico(classeDominio = Autor.class, nomeCampo = "email")
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;
	
	private Date dataRegistro;

	public Autor geraNovoAutor() {
		Autor novoAutor = new Autor(this.nome, this.email, this.descricao);
		return novoAutor;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}



	
	
}
