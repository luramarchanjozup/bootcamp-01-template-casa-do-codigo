package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.Repository.CategoriaJpaRepository;
import com.itau.cdc.entity.CategoriaEntity;
import com.itau.cdc.model.Categoria;
import com.itau.cdc.model.DTO.NovaCategoriaRequest;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaJpaRepository categoriaJpaRepository;
	
	public Long IncluirCategoria(@Valid NovaCategoriaRequest request) {
		
		@Valid
		Categoria novaCategoria = request.toModel();
		
		CategoriaEntity categoriaEntity = new CategoriaEntity();
		
		categoriaEntity = categoriaJpaRepository.save(novaCategoria.toEntity(categoriaEntity));
		
		return categoriaEntity.getId();
	}

}
