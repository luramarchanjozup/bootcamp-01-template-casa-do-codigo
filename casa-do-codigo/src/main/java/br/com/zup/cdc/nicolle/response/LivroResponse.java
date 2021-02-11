package br.com.zup.cdc.nicolle.response;

import org.springframework.data.domain.Page;

import br.com.zup.cdc.nicolle.model.Livro;

public class LivroResponse {
	
	private Long id;
	private String titulo;
	
	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static Page<LivroResponse> converter(Page<Livro> livro) {
		return livro.map(LivroResponse::new);
	}
	
	
	
	

}
