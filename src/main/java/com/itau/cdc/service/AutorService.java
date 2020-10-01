package com.itau.cdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.cdc.Repository.AutorJpaRepository;
import com.itau.cdc.entity.AutorEntity;
import com.itau.cdc.model.Autor;

@Service
public class AutorService {

	@Autowired
	private AutorJpaRepository autorJpaRepository;
	
	public Long IncluirAutor(Autor novoAutor) {
				
		AutorEntity autorEntity = new AutorEntity();
		
		autorEntity = autorJpaRepository.save(novoAutor.toEntity(autorEntity));
		
		return autorEntity.getId();
		
	}
	
}
