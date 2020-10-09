package com.casadocodigo.controller;

import com.casadocodigo.entity.Purchase;
import com.casadocodigo.repository.CouponRepository;
import com.casadocodigo.requests.PurchaseRequest;
import com.casadocodigo.responses.PurchaseDetailResponse;
import com.casadocodigo.validators.CouponValidator;
import com.casadocodigo.validators.CpfOrCnpjValidator;
import com.casadocodigo.validators.StateBelongToCountryValidator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseDetailController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	CouponRepository couponRepository;

	@GetMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> detail(@PathVariable("id") Long id) {

		Purchase purchase = manager.find(Purchase.class, id);

		System.out.println(purchase);

		if (purchase == null) {
			return ResponseEntity.notFound().build();
		}

		PurchaseDetailResponse response = new PurchaseDetailResponse(purchase);

		return ResponseEntity.ok(response);
	}

}
