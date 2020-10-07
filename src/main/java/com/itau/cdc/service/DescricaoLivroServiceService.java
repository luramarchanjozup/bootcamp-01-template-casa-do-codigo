package com.itau.cdc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.DetalheSiteLivroResponse;
import com.itau.cdc.entity.Livro;

@Service
//4
public class DescricaoLivroServiceService {

	@PersistenceContext
	private EntityManager manager;
	
	//1
	public DetalheSiteLivroResponse DescricaoLivro(Long idLivro) {
		//1
		Livro livro = manager.find(Livro.class, idLivro);
		//1
		if (livro == null){
			return null;
		}
		//1
		DetalheSiteLivroResponse detalheLivro = new DetalheSiteLivroResponse(livro);
		
		return detalheLivro;
	}

}
