package br.com.itau.casadocodigo.casadocodigoAPI.model.dto;

import javax.validation.constraints.NotBlank;

public class PaisDTO {

	private int id;
	private String nome;

	public PaisDTO(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Deprecated
	public PaisDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
