package com.casadocodigo.entity;

import com.casadocodigo.annotations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	private String codeCoupon;

	@Positive
	@NotNull
	private BigDecimal descount;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate couponValidity;

	@Deprecated
	public Coupon() {

	}

	public Coupon(@NotBlank String codeCoupon, @Positive @NotNull BigDecimal descount, @Future LocalDate couponValidity) {
		this.codeCoupon = codeCoupon;
		this.descount = descount;
		this.couponValidity = couponValidity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodeCoupon(String codeCoupon) {
		this.codeCoupon = codeCoupon;
	}

	public void setDescount(BigDecimal descount) {
		this.descount = descount;
	}

	public void setCouponValidity(LocalDate couponValidity) {
		this.couponValidity = couponValidity;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Coupon{" +
				"codeCoupon='" + codeCoupon + '\'' +
				", descount=" + descount +
				", couponValidity=" + couponValidity +
				'}';
	}
}
