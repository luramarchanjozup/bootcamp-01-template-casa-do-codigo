package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.AutorRequest;
import com.itau.cdc.Repository.AutorJpaRepository;
import com.itau.cdc.entity.Autor;

@Service
public class AutorService {

	//1
	@Autowired
	private AutorJpaRepository autorJpaRepository;
	
	public Long IncluirAutor(@Valid AutorRequest request) {
		
		if((autorJpaRepository.findByEmail(request.getEmail()).isPresent())) {
			throw new IllegalArgumentException("Já existe um(a) outro(a) autor(a) com o mesmo email " + request.getEmail());
		}
		
		@Valid
		Autor novoAutor = request.toModel();
		
		novoAutor = autorJpaRepository.save(novoAutor);
		
		return novoAutor.getId();
		
	}
	
}
