package com.casadocodigo.casadocodigo.DetalhesLivro;

import com.casadocodigo.casadocodigo.Autor.Autor;

public class DetalheAutor {

	private String nome;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public DetalheAutor(Autor autor) {
		super();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

}
