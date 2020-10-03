package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.NovoPaisRequest;
import com.itau.cdc.model.Pais;

@Service
public class PaisService {

	@Autowired
	private PaisJpsRepository paisJpaRepository;
	
	public Long IncluirPais(@Valid NovoPaisRequest request) {
		
		@Valid
		Pais novoPais = request.toModel();
		
		novoPais = paisJpaRepository.save(novoPais);
		
		return novoPais.getId();
	}

}
