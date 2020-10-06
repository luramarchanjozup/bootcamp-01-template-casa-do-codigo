package com.itau.cdc.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CupomRequest;
import com.itau.cdc.Repository.CupomJpaRepository;
import com.itau.cdc.model.Cupom;

@Service
public class NovoCupomService {
	
	@Autowired
	private CupomJpaRepository cupomJpaRepository;
	
	public Long NovoCupom(@Valid CupomRequest request) {

		Cupom novoCupom = request.toModel();
		
		cupomJpaRepository.save(novoCupom);
		
		return novoCupom.getId();
	}
	
	public Optional<Cupom> ConsultaCupom(Long idCupom) {
		
		return cupomJpaRepository.findById(idCupom);
		
	}

}
