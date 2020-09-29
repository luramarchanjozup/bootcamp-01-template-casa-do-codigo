package com.casadocodigo.casadocodigo.FluxoPagamento.Compra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.casadocodigo.Cupom.CupomRepository;
import com.casadocodigo.casadocodigo.Validation.ConfirmarRelacaoEstadoPais;
import com.casadocodigo.casadocodigo.Validation.ValidarCupom;
import com.casadocodigo.casadocodigo.Validation.ValidarDocumento;

@RestController
public class ComprasController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private ConfirmarRelacaoEstadoPais confirmarRelacaoEstadoPais;

	@Autowired
	private ValidarDocumento validarDocumento;
	
	@Autowired
	private ValidarCupom validarCupom;

	@Autowired
	private CupomRepository cupomRepository;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validarDocumento, validarCupom, confirmarRelacaoEstadoPais);
	}

	@PostMapping("/minhacompra")
	@Transactional
	public String efetivarCompra(@Valid @RequestBody CompraDto request) {
		Compra novaCompra = request.toModel(manager, cupomRepository);
		manager.persist(novaCompra);
		return novaCompra.toString();
	}
}
