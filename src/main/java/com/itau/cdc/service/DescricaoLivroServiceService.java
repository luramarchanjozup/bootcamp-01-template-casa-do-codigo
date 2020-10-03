package com.itau.cdc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.itau.cdc.DTO.DetalheSiteLivroResponse;
import com.itau.cdc.model.Livro2;

@Service
public class DescricaoLivroServiceService {

	@PersistenceContext
	private EntityManager manager;
	
	public DetalheSiteLivroResponse DescricaoLivro(Long idLivro) {
		
		Livro2 livro = manager.find(Livro2.class, idLivro);
		
		Assert.state(livro!=null, "Livro não existe");
		
		DetalheSiteLivroResponse detalheLivro = new DetalheSiteLivroResponse(livro);
		
		return detalheLivro;
	}

}
