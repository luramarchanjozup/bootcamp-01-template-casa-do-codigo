package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CategoriaRequest;
import com.itau.cdc.Repository.CategoriaJpaRepository;
import com.itau.cdc.model.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaJpaRepository categoriaJpaRepository;
	
	public Long IncluirCategoria(@Valid CategoriaRequest request) {
		
		@Valid
		Categoria novaCategoria = request.toModel();
		
		novaCategoria = categoriaJpaRepository.save(novaCategoria);
		
		return novaCategoria.getId();
	}

}
