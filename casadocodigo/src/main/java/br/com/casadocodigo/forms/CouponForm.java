package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Coupon;
import br.com.casadocodigo.validation.Unique;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.OffsetDateTime;

public class CouponForm {

    @NotBlank
    @Unique(fieldName = "code", domainClass = Coupon.class)
    private String code;

    @NotBlank
    @Positive
    private Double discount;

    @Future
    private OffsetDateTime validate;

    @Deprecated
    public CouponForm() {};

    public CouponForm(String code, Double discount, OffsetDateTime validate){
        this.code = code;
        this.discount = discount;
        this.validate = validate;
    }

    public Coupon toEntity(){
        return new Coupon(code, discount, validate);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
