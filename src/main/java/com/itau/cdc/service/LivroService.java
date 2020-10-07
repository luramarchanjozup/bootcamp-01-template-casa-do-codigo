package com.itau.cdc.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.LivroRequest;
import com.itau.cdc.DTO.LivroResponse;
import com.itau.cdc.Repository.LivroJpaRepository;
import com.itau.cdc.configuration.exception.ApiErroException;
import com.itau.cdc.entity.Livro;

@Service
//6
public class LivroService {

	@Autowired
	private LivroJpaRepository livroJpaRepository;

	@PersistenceContext
	private EntityManager manager;

	//1
	public Long IncluirLivro(@Valid LivroRequest request) {
		//1
		if ((livroJpaRepository.findByTitulo(request.getTitulo()).isPresent())) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe um outro livro com o mesmo titulo " + request.getTitulo());
		}
		//1	
		Livro novoLivro = request.toModel(manager);

		novoLivro = livroJpaRepository.save(novoLivro);

		return novoLivro.getId();
	}
	//1
	public List<LivroResponse> ListaLivros() {
		//1
		Iterable<Livro> listaLivros = livroJpaRepository.findAll();
		//1
		List<LivroResponse> listaLivrosResponse = StreamSupport.stream(listaLivros.spliterator(), false)
				.map(livro -> livro.toResponse()).collect(Collectors.toList());

		return listaLivrosResponse;
	}

}
