package br.com.zup.cdc.nicolle.request;

import javax.validation.constraints.NotBlank;

import br.com.zup.cdc.nicolle.model.Pais;
import br.com.zup.cdc.nicolle.validadores.SemValorRepetido;

public class NovoPaisRequest {
	
	@NotBlank
	@SemValorRepetido(dominioClasse = Pais.class, nomeCampo = "pais")
	private String pais;

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Pais novoPais() {
		
		return new Pais(pais);
	}

	
	
	

}
