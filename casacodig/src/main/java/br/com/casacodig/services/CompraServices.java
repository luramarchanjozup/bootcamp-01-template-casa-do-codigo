package br.com.casacodig.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import br.com.casacodig.dto.CompraDTO;
import br.com.casacodig.model.Compra;

//Contagem de Pontos - TOTAL:3
//1 - CompraDTO
//1 - Compra
//1 - If

@Service
public class CompraServices {
	
	@PersistenceContext
	private EntityManager manager;

	
	public Compra salvar(CompraDTO compradto) throws Exception {
		Compra compra = compradto.toModel(manager);
		if (compra.getEstado() == null) throw new Exception ("Estado não pertence ao pais informado");
		compra.aplicaCupom();
		manager.persist(compra);
		return compra;
	}
	
	
	public Compra listarCompras (Long id) {
		Compra compra = manager.find(Compra.class, id);
		return compra;
	}

}
