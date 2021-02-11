package br.com.zup.cdc.nicolle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private @NotBlank String pais;
	
	@Deprecated
	public Pais() {}
	
	public Pais(@NotBlank String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", pais=" + pais + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
