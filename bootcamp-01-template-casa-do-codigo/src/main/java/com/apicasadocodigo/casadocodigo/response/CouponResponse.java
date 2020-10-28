package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.Coupon;
import com.apicasadocodigo.casadocodigo.util.ConvertDate;

import java.math.BigDecimal;

public class CouponResponse {

    private String cod;

    private BigDecimal discountValue;

    private String validate;

    public CouponResponse(Coupon coupon) {
        this.cod = coupon.getCod();
        this.discountValue = coupon.getDiscountValue();
        this.validate = ConvertDate.toBrazilFormat(coupon.getValidate());
    }

    public String getCod() {
        return cod;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public String getValidateCoupon() {
        return validate;
    }
}
