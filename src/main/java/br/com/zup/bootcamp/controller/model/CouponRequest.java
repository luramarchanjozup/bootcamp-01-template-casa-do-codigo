package br.com.zup.bootcamp.controller.model;

import br.com.zup.bootcamp.controller.validator.annotation.Unique;
import br.com.zup.bootcamp.domain.model.Coupon;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

// Intrinsic charge = 1
public class CouponRequest {
    @NotBlank(message = "Code is mandatory")
    @Unique(message = "Code already exist", fieldName = "code", domainClass = Coupon.class)
    private String code;

    @NotNull(message = "Percentage is mandatory")
    @Min(value = 1, message = "Percentage must be greater or equal 1")
    @Max(value = 100, message = "Percentage must be less or equal 100")
    private Integer percentage;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Expiration date is mandatory")
    @Future(message = "Expiration date must be in future")
    private LocalDate expirationDate;

    public String getCode() {
        return code;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Coupon convert(){
        Coupon coupon = new Coupon();
        coupon.setCode(this.code);
        coupon.setPercentage(this.percentage);
        coupon.setExpirationDate(this.expirationDate);
        return coupon;
    }
}
