package com.casadocodigo.requests;

import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.casadocodigo.annotations.ExistsValue;
import com.casadocodigo.entity.*;
import com.casadocodigo.repository.CouponRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import org.springframework.util.StringUtils;

public class PurchaseRequest {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String name;

	@NotBlank
	private String lastName;

	@NotBlank
	private String document;

	@NotBlank
	private String adress;

	@NotBlank
	private String complement;

	@NotNull
	private Long phone;

	@NotNull
	private Long cep;
	
	@NotNull
	@ExistsValue(domainClass = Country.class, fieldName = "id", message = "O País precisa ser válido.")
	private Long idCountry;
	
	@NotNull
	@ExistsValue(domainClass = State.class, fieldName = "id", message = "O Estado precisa ser válido")
	private Long idState;
	
	private CartRequest cart;

	@ExistsValue(domainClass = Coupon.class, fieldName = "code", message = "Cumpo inválido")
	private String coupon;
	

	public PurchaseRequest(@NotBlank @Email String email, @NotBlank String name, @NotBlank String lastName,
			@NotBlank String document, @NotBlank String adress, @NotBlank String complement, @NotNull Long phone,
			@NotNull Long cep, @NotNull Long idCountry, @NotNull Long idState, @Valid @NotNull CartRequest cart) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.document = document;
		this.adress = adress;
		this.complement = complement;
		this.phone = phone;
		this.cep = cep;
		this.idCountry = idCountry;
		this.idState = idState;
		this.cart = cart;
	}
	
	public String getDocument() {
		return document;
	}
	
	
	public Long getIdCountry() {
		return idCountry;
	}

	public Long getIdState() {
		return idState;
	}

	public boolean hasState() {
		return idState != null;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public Optional<String> getCoupon() {
		return Optional.ofNullable(coupon);
	}

	public Purchase toModel(EntityManager manager, CouponRepository couponRepository) {
		@NotNull
		Country country = manager.find(Country.class, idCountry);
		
		Function<Purchase, Cart> newCart  = cart.toModel(manager);
		
		Purchase purchase = new Purchase(email, name, lastName, document, adress, complement, phone, cep, country, newCart);
		
		if(idState != null) {
			purchase.setState(manager.find(State.class, idState));
		}

		if (StringUtils.hasText(coupon)){
			Coupon couponToFind = couponRepository.getByCode(coupon);
			purchase.applyCoupon(couponToFind);
		}
		
		return purchase;
	}

	public boolean documentIsValid() {
		Assert.hasLength(document, "O documento precisa estar preenchido");
		
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		return cpfValidator.isValid(document, null) || cnpjValidator.isValid(document, null);
	}
}
