package br.com.zup.cdc.nicolle.request;

import javax.validation.constraints.NotBlank;

import br.com.zup.cdc.nicolle.model.Estado;
import br.com.zup.cdc.nicolle.model.Pais;
import br.com.zup.cdc.nicolle.repository.PaisRepository;
import br.com.zup.cdc.nicolle.validadores.SemValorRepetido;

public class NovoEstadoRequest {
	@NotBlank
	@SemValorRepetido(dominioClasse = Estado.class, nomeCampo = "estado")
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
