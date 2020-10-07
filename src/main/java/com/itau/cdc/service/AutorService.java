package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.AutorRequest;
import com.itau.cdc.Repository.AutorJpaRepository;
import com.itau.cdc.configuration.exception.ApiErroException;
import com.itau.cdc.entity.Autor;

@Service
//3
public class AutorService {

	@Autowired
	private AutorJpaRepository autorJpaRepository;
	//1
	public Long IncluirAutor(@Valid AutorRequest request) {
		//1
		if((autorJpaRepository.findByEmail(request.getEmail()).isPresent())) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe um(a) outro(a) autor(a) com o mesmo email " + request.getEmail());
		}
		
		@Valid
		//1
		Autor novoAutor = request.toModel();
		
		novoAutor = autorJpaRepository.save(novoAutor);
		
		return novoAutor.getId();
		
	}
	
}
