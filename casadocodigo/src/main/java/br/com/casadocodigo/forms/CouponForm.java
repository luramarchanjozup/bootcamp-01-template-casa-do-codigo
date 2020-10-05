package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.validation.Unique;

import javax.validation.constraints.NotBlank;

public class CouponForm {

    @NotBlank
    @Unique(fieldName = "code", domainClass = Coupon.class)
    private String code;

    @NotBlank
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
