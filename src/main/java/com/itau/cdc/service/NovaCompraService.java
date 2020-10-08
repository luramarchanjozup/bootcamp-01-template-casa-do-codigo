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
//5
public class NovaCompraService {

	@PersistenceContext
	private EntityManager manager;
	//1
	public Long NovaCompra(@Valid CompraRequest request) {
		
		@Valid
		//1
		Compra novaCompra = request.toModel(manager);
		
		manager.persist(novaCompra);
		
		return novaCompra.getId();
	}
	//1
	public CompraResponse consultaCompra(@NotNull Long id_compra) {
		//1
		Compra compra = manager.find(Compra.class, id_compra);
		//1
		if(compra == null) {
			return null;
		}
		return compra.toResponse();
	}

}
