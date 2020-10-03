package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.PaisRequest;
import com.itau.cdc.Repository.PaisJpaRepository;
import com.itau.cdc.model.Pais;

@Service
public class PaisService {

	@Autowired
	private PaisJpaRepository paisJpaRepository;
	
	public Long IncluirPais(@Valid PaisRequest request) {
		
		@Valid
		Pais novoPais = request.toModel();
		
		novoPais = paisJpaRepository.save(novoPais);
		
		return novoPais.getId();
	}

}
