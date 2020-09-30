package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Coupon;

public class CouponForm {

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

}
