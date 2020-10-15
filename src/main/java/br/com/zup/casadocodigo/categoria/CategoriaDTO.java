package br.com.zup.casadocodigo.categoria;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validacao.ValorUnico;

public class CategoriaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@ValorUnico(classeDominio = Categoria.class, nomeCampo = "nome")
	private String nome;
	
	@Deprecated
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Categoria gerarCategoria() {
		Categoria gerarCategoria = new Categoria(nome);
		return gerarCategoria;
	}
	
	
	

}
