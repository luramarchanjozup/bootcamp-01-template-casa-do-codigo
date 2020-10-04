package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.validation.Unique;

public class CouponForm {

    @Unique(fieldName = "code", domainClass = Coupon.class)
    private String code;
    private Double discount;

    @Deprecated
    public CouponForm() {};

    public CouponForm(String code, Double discount){
        this.code = code;
        this.discount = discount;
    }

    public Coupon toEntity(){
        return new Coupon(code, discount);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
