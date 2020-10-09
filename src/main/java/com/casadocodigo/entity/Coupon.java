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
	private String code;

	@Positive
	@NotNull
	private BigDecimal descount;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate couponValidity;

	@Deprecated
	public Coupon() {

	}

	public Coupon(@NotBlank String code, @Positive @NotNull BigDecimal descount, @Future LocalDate couponValidity) {
		this.code = code;
		this.descount = descount;
		this.couponValidity = couponValidity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
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

	public BigDecimal getDescount() {
		return descount;
	}

	public LocalDate getCouponValidity() {
		return couponValidity;
	}

	@Override
	public String toString() {
		return "Coupon{" +
				"code='" + code + '\'' +
				", descount=" + descount +
				", couponValidity=" + couponValidity +
				'}';
	}

	public boolean valid (){
		return LocalDate.now().compareTo(this.couponValidity) <= 0;
	}
}
