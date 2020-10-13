package com.casadocodigo.responses;

import com.casadocodigo.entity.Country;
import com.casadocodigo.entity.Coupon;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CouponResponse {

    private Long id;
    private String code;
    private BigDecimal descount;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate couponValidity;

    public CouponResponse(Coupon coupon) {
        id = coupon.getId();
        code = coupon.getCode();
        descount = coupon.getDescount();
        couponValidity = coupon.getCouponValidity();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getDescount() {
        return descount;
    }

    public LocalDate getCouponValidity() {
        return couponValidity;
    }
}
