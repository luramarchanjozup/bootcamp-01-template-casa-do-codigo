package com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.casadocodigo.responses.PurchaseDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.entity.Purchase;
import com.casadocodigo.repository.CouponRepository;
import com.casadocodigo.requests.PurchaseRequest;
import com.casadocodigo.validators.CouponValidator;
import com.casadocodigo.validators.CpfOrCnpjValidator;
import com.casadocodigo.validators.StateBelongToCountryValidator;
import com.google.gson.Gson;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	CouponValidator couponvalidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new CpfOrCnpjValidator(), new StateBelongToCountryValidator(), couponvalidator);
	}

	@PostMapping(value = "")
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestBody PurchaseRequest request, UriComponentsBuilder uriComponentsBuilder) {

		Purchase purchase = request.toModel(manager, couponRepository);
		manager.persist(purchase);

		return ResponseEntity.created(uriComponentsBuilder.path("/api/purchase/{id}")
				.buildAndExpand(purchase.getId()).toUri()).build();

	}

}
