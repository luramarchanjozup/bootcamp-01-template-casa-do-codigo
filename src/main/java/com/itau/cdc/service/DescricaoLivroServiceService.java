package com.itau.cdc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.DetalheSiteLivroResponse;
import com.itau.cdc.entity.Livro;

@Service
public class DescricaoLivroServiceService {

	@PersistenceContext
	private EntityManager manager;
	
	public DetalheSiteLivroResponse DescricaoLivro(Long idLivro) {
		
		Livro livro = manager.find(Livro.class, idLivro);
		
		if (livro == null){
			return null;
		}
		
		DetalheSiteLivroResponse detalheLivro = new DetalheSiteLivroResponse(livro);
		
		return detalheLivro;
	}

}
