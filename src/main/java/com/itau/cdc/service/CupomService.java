package com.itau.cdc.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.NovoCupomRequest;
import com.itau.cdc.Repository.CupomJpaRepository;
import com.itau.cdc.entity.Cupom2;

@Service
public class CupomService {

	@Autowired
	private CupomJpaRepository cupomJpaRepository;

	public Long NovoCupom(@Valid NovoCupomRequest request) {

		Cupom2 novoCupom = request.toModel();

		if(cupomJpaRepository.findByCodigo(novoCupom.getCodigo()).isPresent()) {
			throw new IllegalArgumentException("Código já cadastrado.");
		}
		
		cupomJpaRepository.save(novoCupom);

		return novoCupom.getId();
	}

	public Optional<Cupom2> ConsultaCupom(String codigoCupom) {

		return cupomJpaRepository.findByCodigo(codigoCupom);

	}

	public Cupom2 AlteraCupom(String codigoCupom, @Valid NovoCupomRequest request) {
		
		Optional<Cupom2> cupomNaBase = cupomJpaRepository.findByCodigo(codigoCupom);
		
		if(!cupomNaBase.isPresent()) {
			return null;
		}
		
		Cupom2 cupomAlterado = request.toModel();
		cupomAlterado.AlteraIdCupom(cupomNaBase);
		
		cupomJpaRepository.save(cupomAlterado);
		
		return cupomAlterado;
		
	}

}
