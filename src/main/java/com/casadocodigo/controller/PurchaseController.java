package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.Purchase;
import com.casadocodigo.requests.PurchaseRequest;
import com.casadocodigo.validators.CpfOrCnpjValidator;
import com.casadocodigo.validators.StateBelongToCountryValidator;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

	@PersistenceContext
	private EntityManager manager;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new CpfOrCnpjValidator(), new StateBelongToCountryValidator());
	}

	Gson gson = new Gson();

	@PostMapping(value = "")
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestBody PurchaseRequest request) {

		Purchase purchase = request.toModel(manager);
		manager.persist(purchase);

		return ResponseEntity.ok(purchase.toString());
	}

}
