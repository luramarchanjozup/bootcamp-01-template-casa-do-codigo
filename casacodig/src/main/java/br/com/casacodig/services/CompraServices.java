package br.com.casacodig.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import br.com.casacodig.dto.CompraDTO;
import br.com.casacodig.model.Compra;


@Service
public class CompraServices {
	
	@PersistenceContext
	private EntityManager manager;

	
	public Compra salvar(CompraDTO compradto) throws Exception {
		Compra compra = compradto.toModel(manager);
		System.out.println("-------------COMPRA SERVICE------------------");
		System.out.println(compra.toString());
		if (compra.getEstado() == null) throw new Exception ("Estado não pertence ao pais informado");
		compra.aplicaCupom();
		System.out.println("-------------COMPRA SERVICE DEPOIS DESCONTO------------------");
		System.out.println(compra.toString());
		manager.persist(compra);
		return compra;
	}

}
