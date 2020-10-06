package com.itau.cdc.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.NovoCupomRequest;
import com.itau.cdc.Repository.CupomJpaRepository;
import com.itau.cdc.entity.Cupom;

@Service
public class CupomService {

	@Autowired
	private CupomJpaRepository cupomJpaRepository;

	public Long NovoCupom(@Valid NovoCupomRequest request) {

		Cupom novoCupom = request.toModel();

		if(cupomJpaRepository.findByCodigo(novoCupom.getCodigo()).isPresent()) {
			throw new IllegalArgumentException("Código já cadastrado.");
		}
		
		cupomJpaRepository.save(novoCupom);

		return novoCupom.getId();
	}

	public Optional<Cupom> ConsultaCupom(Long idCupom) {

		return cupomJpaRepository.findById(idCupom);

	}

	public Cupom AlteraCupom(String codigoCupom, @Valid NovoCupomRequest request) {
		
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
