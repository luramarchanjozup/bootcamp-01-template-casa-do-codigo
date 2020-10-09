package com.casadocodigo.controller;

import com.casadocodigo.entity.Coupon;
import com.casadocodigo.requests.CouponRequest;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

	@PersistenceContext
	private EntityManager manager;

	Gson gson = new Gson();

	@PostMapping(value = "")
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestBody CouponRequest request) {

		Coupon coupon = request.toModel();
		manager.persist(coupon);
		String result = gson.toJson(coupon);

		return ResponseEntity.ok(result);
	}

	@PostMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> update (@PathVariable(value = "id") Long id, @Valid @RequestBody CouponRequest request){

		Coupon coupon = manager.find(Coupon.class, id);

		if(coupon == null) {
			return ResponseEntity.notFound().build();
		}

		coupon.setCodeCoupon(request.getCodeCoupon());
		coupon.setCouponValidity(request.getCouponValidity());
		coupon.setDescount(request.getDescount());

		manager.merge(coupon);
		String result = gson.toJson(coupon);

		return ResponseEntity.ok(result);
	}

}
