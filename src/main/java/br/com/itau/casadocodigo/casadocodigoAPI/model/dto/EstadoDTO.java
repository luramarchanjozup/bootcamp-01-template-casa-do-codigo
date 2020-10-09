package br.com.itau.casadocodigo.casadocodigoAPI.model.dto;

public class EstadoDTO {

	private int id;
	private String nome;

	@Deprecated
	public EstadoDTO() {

	}

	public EstadoDTO(int id, String nome) {
		this.id = id;
		this.nome = nome;
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
