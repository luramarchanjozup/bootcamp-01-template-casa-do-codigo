package br.com.zup.casadocodigo.autor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOR")
public class Autor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 316809177616776372L;

	@Id
	@Column(name = "ID_AUTOR")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAutor;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "DATA_REGISTRO")
	private LocalDate dataRegistro;

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataRegistro = LocalDate.now();
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

	public void setDescrição(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

		
}
