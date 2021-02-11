package com.casaDoCodigo.Nicolle.Estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.casaDoCodigo.Nicolle.Pais.Pais;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private @NotBlank String estado;
	private @ManyToOne Pais pais;
	
	@Deprecated
	public Estado() {}
	
	public Estado(@NotBlank String estado, @NotBlank Pais pais) {
		this.estado = estado;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", estado=" + estado + ", pais=" + pais + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
	

}
