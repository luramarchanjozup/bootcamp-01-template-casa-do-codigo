package br.com.zup.cdc.nicolle.response;

import br.com.zup.cdc.nicolle.model.Pais;
import br.com.zup.cdc.nicolle.repository.PaisRepository;

public class PaisResponse {

	
	private Pais pais;

	public PaisResponse(Pais pais) {
		this.pais = pais;
	}

	public Pais getPais() {
		return pais;
	}
	
		
	

}
