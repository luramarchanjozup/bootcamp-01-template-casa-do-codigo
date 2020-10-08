package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CategoriaRequest;
import com.itau.cdc.Repository.CategoriaJpaRepository;
import com.itau.cdc.configuration.exception.ApiErroException;
import com.itau.cdc.entity.Categoria;

@Service
//3
public class CategoriaService {

	@Autowired
	private CategoriaJpaRepository categoriaJpaRepository;
	
	//1
	public Long IncluirCategoria(@Valid CategoriaRequest request) {
		//1
		if((categoriaJpaRepository.findByNome(request.getNome()).isPresent())) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe uma outra categoria com o mesmo nome " + request.getNome());
		}
		
		@Valid
		//1
		Categoria novaCategoria = request.toModel();
		
		novaCategoria = categoriaJpaRepository.save(novaCategoria);
		
		return novaCategoria.getId();
	}

}
