package com.casadocodigo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CouponApplied {

	@ManyToOne
	private Coupon coupon;

	@Positive
	@NotNull
	private BigDecimal descount;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate couponValidity;

	@Deprecated
	public CouponApplied() {

	}

	public CouponApplied(Coupon coupon) {
		this.coupon = coupon;
		this.descount = coupon.getDescount();
		this.couponValidity = coupon.getCouponValidity();
	}

	@Override
	public String toString() {
		return "CouponApplied{" +
				"coupon=" + coupon +
				", descount=" + descount +
				", couponValidity=" + couponValidity +
				'}';
	}
}
