package br.com.casadocodigo.dtos;


import br.com.casadocodigo.models.Coupon;

public class CouponDto {

    private String discount;
    private String code;

    public CouponDto(Coupon coupon){
        this.code = coupon.getCode();
        this.discount = coupon.getDiscount();
    }

}
