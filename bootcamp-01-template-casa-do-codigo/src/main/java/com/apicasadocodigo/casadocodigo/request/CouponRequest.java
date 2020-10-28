package com.apicasadocodigo.casadocodigo.request;


import com.apicasadocodigo.casadocodigo.model.Coupon;
import com.apicasadocodigo.casadocodigo.util.ConvertDate;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CouponRequest {

    @NotEmpty
    @NotNull
    private String cod;

    @NotNull
    @Positive
    private BigDecimal percentValue;

    @FutureOrPresent
    private LocalDate validateDate;

    public CouponRequest(@NotEmpty @NotNull String cod, @NotNull @Positive BigDecimal percentValue,
                         String validateDate) {

        this.cod = cod;
        this.percentValue = percentValue;
        this.validateDate = ConvertDate.toLocalDate(validateDate);
    }

    public Coupon toModel(){
        return new Coupon(this.cod, this.percentValue, this.validateDate);
    }

    public String getCod() {
        return cod;
    }

    public BigDecimal getPercentValue() {
        return percentValue;
    }

    public LocalDate getValidateDate() {
        return validateDate;
    }
}
