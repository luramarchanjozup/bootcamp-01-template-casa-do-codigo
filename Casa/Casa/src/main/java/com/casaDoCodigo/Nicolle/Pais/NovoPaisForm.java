package com.casaDoCodigo.Nicolle.Pais;

import javax.validation.constraints.NotBlank;

import com.casaDoCodigo.Nicolle.Validadores.MinhaAnotacao;

public class NovoPaisForm {
	
	@NotBlank
	@MinhaAnotacao(dominioClasse = Pais.class, nomeCampo = "pais")
	private String pais;
	

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}



	public Pais novoPais() {
		
		return new Pais(pais);
	}
	
	
}
