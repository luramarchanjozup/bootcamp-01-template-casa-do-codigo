package com.itau.cdc.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CupomRequest;
import com.itau.cdc.Repository.CupomJpaRepository;
import com.itau.cdc.configuration.exception.ApiErroException;
import com.itau.cdc.entity.Cupom;

@Service
//6
public class CupomConsultaService {

	@Autowired
	// 1
	private Optional<Cupom> cupomNaBase;
	
	@Autowired
	private CupomJpaRepository cupomJpaRepository;

	// 1
	public Optional<Cupom> ConsultaCupom(String codigoCupom) {
		cupomNaBase = cupomJpaRepository.findByCodigo(codigoCupom);
		// 1
		if (!cupomNaBase.isPresent()) {
			throw new ApiErroException(HttpStatus.NOT_FOUND, "Cupom não encontrado.");
		}
		return cupomNaBase;

	}

	// 1
	public Cupom AlteraCupom(String codigoCupom, @Valid CupomRequest request) {

		cupomNaBase = cupomJpaRepository.findByCodigo(codigoCupom);

		// 1
		if (!cupomNaBase.isPresent()) {
			throw new ApiErroException(HttpStatus.NOT_FOUND, "Cupom não encontrado.");
		}

		// 1
		Cupom cupomAlterado = request.toModel();
		cupomAlterado.AlteraIdCupom(cupomNaBase);

		cupomJpaRepository.save(cupomAlterado);

		return cupomAlterado;

	}
}
