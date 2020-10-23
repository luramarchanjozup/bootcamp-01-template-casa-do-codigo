package com.guiferrini.CasaCodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "autor")
public class Autor {
	
	@Id
	@Column(name="id",nullable=false)
	//@SequenceGenerator(name="autor_seq",sequenceName = "autor_seq_id",initialValue = 1,allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="autor_seq")
	//private Long id;
	@GeneratedValue(generator = "UUID", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@NotBlank(message = "Nome obrigatório")
	private String nome;
	
	@NotBlank(message = "Email obrigatório")
	@Email (message = "Favor digitar um Email válido")
	private String email;
	
	@NotBlank(message = "Descrição obrigatório")
	@Size(max=400, message = "Máximo 400 caracteres")
	private String descricao;
	
	private LocalDateTime horaRegistro = LocalDateTime.now();
	 
	@Deprecated
	public Autor() {
	}

	public Autor(
			@NotBlank String nome, 
			@NotBlank @Email String email, 
			@NotBlank @Size(max=400) String descricao
			) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String toString() {
		return nome
				+ " "
				+ email
				+ " "
				+ descricao
				+ " "
				+ horaRegistro; 
	}
}

