package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.Repository.AutorJpaRepository;
import com.itau.cdc.entity.AutorEntity;
import com.itau.cdc.model.Autor;
import com.itau.cdc.model.DTO.NovoAutorRequest;

@Service
public class AutorService {

	//1
	@Autowired
	private AutorJpaRepository autorJpaRepository;
	
	public Long IncluirAutor(@Valid NovoAutorRequest request) {
		
		@Valid
		Autor novoAutor = request.toModel();
		
		AutorEntity autorEntity = new AutorEntity();
		
		autorEntity = autorJpaRepository.save(novoAutor.toEntity(autorEntity));
		
		return autorEntity.getId();
		
	}
	
}
