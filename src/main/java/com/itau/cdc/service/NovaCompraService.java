package com.itau.cdc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CompraRequest;
import com.itau.cdc.entity.NovaCompra;

@Service
public class NovaCompraService {

	@PersistenceContext
	private EntityManager manager;
	
	public Long NovaCompra(@Valid CompraRequest request) {
		
		NovaCompra novaCompra = request.toModel(manager);
		
		manager.persist(novaCompra);
		
		return novaCompra.getId();
	}

}
