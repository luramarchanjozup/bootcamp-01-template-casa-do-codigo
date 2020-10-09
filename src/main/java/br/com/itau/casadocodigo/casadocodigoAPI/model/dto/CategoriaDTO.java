package br.com.itau.casadocodigo.casadocodigoAPI.model.dto;

public class CategoriaDTO {

	private Integer id;
	private String nome;

	public CategoriaDTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Deprecated
	public CategoriaDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
