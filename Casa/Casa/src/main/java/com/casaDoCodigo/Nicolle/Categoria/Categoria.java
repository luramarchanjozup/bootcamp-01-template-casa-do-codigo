package com.casaDoCodigo.Nicolle.Categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String categoria;
	
	@Deprecated
	public Categoria() {
	}

	public Categoria(@NotBlank String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Categoria[categoria=" + categoria + "]";
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
