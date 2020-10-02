package com.casadocodigo.casaDoCodigo.controllers.form;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class CouponForm {
    
    @NotBlank
    private String code;
    @Min(value = 1)
    private Integer percentage;
    @NotNull @JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING) @Future
    private LocalDate expirationDate;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

}
