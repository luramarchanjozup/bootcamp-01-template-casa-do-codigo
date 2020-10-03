package com.itau.cdc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.LivroRequest;
import com.itau.cdc.Repository.AutorJpaRepository;
import com.itau.cdc.Repository.CategoriaJpaRepository;
import com.itau.cdc.Repository.LivroJpaRepository;
import com.itau.cdc.model.Livro2;

@Service
public class LivroService {

	@Autowired
	private LivroJpaRepository livroJpaRepository;
	
	@Autowired
	private CategoriaJpaRepository categoriaJpaRepository;
	
	@Autowired
	private AutorJpaRepository autorJpaRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	public Long IncluirLivro(@Valid LivroRequest request) {

		Livro2 novoLivro = request.toModel(request, categoriaJpaRepository, autorJpaRepository, manager);
		
		novoLivro = livroJpaRepository.save(novoLivro);
		
		return novoLivro.getId();
	}

	public Iterable<Livro2> ListaLivros() {
		return livroJpaRepository.findAll();
	}

}
