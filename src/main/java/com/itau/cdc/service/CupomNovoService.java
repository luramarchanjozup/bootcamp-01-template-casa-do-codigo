package com.itau.cdc.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CupomRequest;
import com.itau.cdc.Repository.CupomJpaRepository;
import com.itau.cdc.configuration.exception.ApiErroException;
import com.itau.cdc.entity.Cupom;

@Service
//3
public class CupomNovoService {

	@Autowired
	private CupomJpaRepository cupomJpaRepository;

	//1
	public Long NovoCupom(@Valid CupomRequest request) {

		//1
		Cupom novoCupom = request.toModel();

		//1
		if(cupomJpaRepository.findByCodigo(novoCupom.getCodigo()).isPresent()) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Código já cadastrado.");
		}
		
		cupomJpaRepository.save(novoCupom);

		return novoCupom.getId();
	}

	

}
