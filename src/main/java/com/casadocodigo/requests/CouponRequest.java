package com.casadocodigo.requests;

import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.entity.Coupon;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class CouponRequest {

    @NotBlank
    @UniqueValue(domainClass = Coupon.class, fieldName = "code", message = "O cupom deve ser único")
    private String code;

    @Positive
    @NotNull
    private BigDecimal descount;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate couponValidity;

    public CouponRequest(@NotBlank String code, @Positive @NotNull BigDecimal descount) {
        this.code = code;
        this.descount = descount;
    }

    public void setCouponValidity(LocalDate couponValidity) {
        this.couponValidity = couponValidity;
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

    public Coupon toModel() {
        return new Coupon(code, descount, couponValidity);
    }
}
