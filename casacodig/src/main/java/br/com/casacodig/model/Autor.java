package br.com.casacodig.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//Contagem de Pontos - TOTAL:0

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank @Email 
	private String email;
	@NotBlank @Size(max = 400)
	private String descricao;
	private LocalDateTime datacriacao = LocalDateTime.now();
	
	@Deprecated
	public Autor() {

	}
	
	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", instanteCriacao=" + datacriacao + "]";
	}

	public String getEmail() {
		return this.email;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}
	
	
}


