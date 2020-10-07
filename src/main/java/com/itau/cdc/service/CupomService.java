package com.itau.cdc.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CupomRequest;
import com.itau.cdc.Repository.CupomJpaRepository;
import com.itau.cdc.entity.Cupom;
import com.itau.cdc.exception.ApiErroException;

@Service
public class CupomService {

	@Autowired
	private CupomJpaRepository cupomJpaRepository;

	public Long NovoCupom(@Valid CupomRequest request) {

		Cupom novoCupom = request.toModel();

		if(cupomJpaRepository.findByCodigo(novoCupom.getCodigo()).isPresent()) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Código já cadastrado.");
		}
		
		cupomJpaRepository.save(novoCupom);

		return novoCupom.getId();
	}

	public Optional<Cupom> ConsultaCupom(String codigoCupom) {

		return cupomJpaRepository.findByCodigo(codigoCupom);

	}

	public Cupom AlteraCupom(String codigoCupom, @Valid CupomRequest request) {
		
		Optional<Cupom> cupomNaBase = cupomJpaRepository.findByCodigo(codigoCupom);
		
		if(!cupomNaBase.isPresent()) {
			return null;
		}
		
		Cupom cupomAlterado = request.toModel();
		cupomAlterado.AlteraIdCupom(cupomNaBase);
		
		cupomJpaRepository.save(cupomAlterado);
		
		return cupomAlterado;
		
	}

}
