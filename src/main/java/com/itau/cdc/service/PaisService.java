package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.PaisRequest;
import com.itau.cdc.Repository.PaisJpaRepository;
import com.itau.cdc.entity.Pais;

@Service
//3
public class PaisService {

	@Autowired
	private PaisJpaRepository paisJpaRepository;
	
	//1
	public Long IncluirPais(@Valid PaisRequest request) {
		//1
		if((paisJpaRepository.findByNome(request.getNome()).isPresent())) {
			throw new IllegalArgumentException("Já existe um outro pais com o mesmo nome " + request.getNome());
		}
		
		@Valid
		//1
		Pais novoPais = request.toModel();
		
		novoPais = paisJpaRepository.save(novoPais);
		
		return novoPais.getId();
	}

}
