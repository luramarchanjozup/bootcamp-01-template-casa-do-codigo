package com.casadocodigo.casadocodigo.FluxoPagamento.Compra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalheComprasController {

	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/compras/{id}")
	public ResponseEntity<CompraDetalhe> detalheCompra(@PathVariable Long id) {
		Compra compra = manager.find(Compra.class, id);
		CompraDetalhe compraDetalhe = new CompraDetalhe(compra);
		return ResponseEntity.ok(compraDetalhe);
	}

}
