package com.itau.cdc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.EstadoRequest;
import com.itau.cdc.Repository.EstadoJpaRepository;
import com.itau.cdc.entity.Estado;
import com.itau.cdc.exception.ApiErroException;

@Service
public class EstadoService {

	@Autowired
	private EstadoJpaRepository estadoJpaRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	public Long IncluirEstado(@Valid EstadoRequest request) {
		
		if((estadoJpaRepository.findByNome(request.getNome()).isPresent())){
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe um outro estado com o mesmo nome " + request.getNome());
		}
			
		@Valid
		Estado novoEstado = request.toModel(manager);
		
		novoEstado = estadoJpaRepository.save(novoEstado);
		
		return novoEstado.getId();
		
	}
	
}
