package com.casadocodigo.entity;

import java.util.Optional;
import java.util.function.Function;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.casadocodigo.annotations.ExistsValue;
import org.springframework.util.Assert;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

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
	
	@ManyToOne
	@Valid
	private Country country;
	
	@Valid
	@ManyToOne
	private State state;
	
	@OneToOne(mappedBy = "purchase", cascade = CascadeType.PERSIST)
	private Cart cart;

	@Embedded
	private CouponApplied couponApplied;

	@Deprecated
	public Purchase(){

	}

	public Purchase(@NotBlank @Email String email, @NotBlank String name, @NotBlank String lastName,
			@NotBlank String document, @NotBlank String adress, @NotBlank String complement, @NotNull Long phone,
			@NotNull Long cep, @Valid Country country, Function<Purchase, Cart> newCart) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.document = document;
		this.adress = adress;
		this.complement = complement;
		this.phone = phone;
		this.cep = cep;
		this.country = country;
		this.cart = newCart.apply(this);
	}

	@Override
	public String toString() {
		return "Purchase{" +
				"id=" + id +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", document='" + document + '\'' +
				", adress='" + adress + '\'' +
				", complement='" + complement + '\'' +
				", phone=" + phone +
				", cep=" + cep +
				", country=" + country +
				", state=" + state +
				", cart=" + cart +
				", couponApplied=" + couponApplied +
				'}';
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDocument() {
		return document;
	}

	public String getAdress() {
		return adress;
	}

	public String getComplement() {
		return complement;
	}

	public Long getPhone() {
		return phone;
	}

	public Long getCep() {
		return cep;
	}

	public Country getCountry() {
		return country;
	}

	public State getState() {
		return state;
	}

	public Cart getCart() {
		return cart;
	}

	public CouponApplied getCouponApplied() {
		return couponApplied;
	}

	public void setState(@NotNull @Valid State state) {
		Assert.notNull(country, "O país não pode ser nulo ");
		Assert.isTrue(state.belongToCountry(country), "O estado não pertence ao pais informado");
		this.state = state;
	}

	public void applyCoupon(Coupon coupon) {
		Assert.isTrue(coupon.valid(), "o cupom não é válido ");
		Assert.isNull(couponApplied, "O cupom deve ser o mesmo");
		this.couponApplied = new CouponApplied(coupon);
	}
}
