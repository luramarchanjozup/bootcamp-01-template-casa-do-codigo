package com.casaDoCodigo.Nicolle.Estado;

import javax.validation.constraints.NotBlank;

import com.casaDoCodigo.Nicolle.Pais.Pais;
import com.casaDoCodigo.Nicolle.Pais.PaisRepository;
import com.casaDoCodigo.Nicolle.Validadores.MinhaAnotacao;

public class NovoEstadoForm {
	
	@NotBlank
	@MinhaAnotacao(dominioClasse = Estado.class, nomeCampo = "estado")
	private String estado;
	
	@NotBlank
	private String paisNome;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPaisNome() {
		return paisNome;
	}

	public void setPaisNome(String paisNome) {
		this.paisNome = paisNome;
	}



	public Estado novoEstado(PaisRepository paisRepository) {
		Pais pais = paisRepository.findByPais(paisNome).get();
		return new Estado(estado,pais);
	}
	
	

}
