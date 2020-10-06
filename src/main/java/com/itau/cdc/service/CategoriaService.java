package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CategoriaRequest;
import com.itau.cdc.Repository.CategoriaJpaRepository;
import com.itau.cdc.entity.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaJpaRepository categoriaJpaRepository;
	
	public Long IncluirCategoria(@Valid CategoriaRequest request) {
		
		if((categoriaJpaRepository.findByNome(request.getNome()).isPresent())) {
			throw new IllegalArgumentException("Já existe uma outra categoria com o mesmo nome " + request.getNome());
		}
		
		@Valid
		Categoria novaCategoria = request.toModel();
		
		novaCategoria = categoriaJpaRepository.save(novaCategoria);
		
		return novaCategoria.getId();
	}

}
