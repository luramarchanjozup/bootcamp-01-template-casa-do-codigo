package com.itau.cdc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.itau.cdc.DTO.CompraRequest;
import com.itau.cdc.DTO.CompraResponse;
import com.itau.cdc.entity.Compra;

@Service
public class NovaCompraService {

	@PersistenceContext
	private EntityManager manager;
	
	public Long NovaCompra(@Valid CompraRequest request) {
		
		@Valid
		Compra novaCompra = request.toModel(manager);
		
		manager.persist(novaCompra);
		
		return novaCompra.getId();
	}

	public CompraResponse consultaCompra(@NotNull Long id_compra) {
		
		Compra compra = manager.find(Compra.class, id_compra);
		
		if(compra == null) {
			return null;
		}else {
			return compra.toResponse();
		}
	}

}
