package com.guiferrini.CasaCodigo.model;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

public class EstadoDTO {

	@NotBlank(message = "Nome é obrigatório")
	@ValorUnico(domainClass=Estado.class, fieldName="nome", message="Nome já existe, favor verificar.")
	private String nome;
	
	@NotNull
	@IdUnico(domainClass=Pais.class, fieldName="id", message="O ID do Pais é obrigatório e tem que ser válido")
	private String idPais;
	
	public EstadoDTO() {
	}

	public EstadoDTO(@NotBlank(message = "Nome é obrigatório") String nome, @NotNull String idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome; 
	} 

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}
	
	public Estado toModel(EntityManager entityManager) {
		
		@NotNull Pais pais = entityManager.find(Pais.class, idPais);
		
		Assert.state(pais != null, "Favor verificar o nome do Pais, este nome não está cadastrado.");
		
		return new Estado(nome, pais);	
	}
	
	@Override //sobreposição
	public String toString() {
		return "Nome: " +
				nome + 
				"Id Pais: " + 
				idPais;
	}
	
}
